package org.zerock.myProject.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myProject.domain.BoardAttachVO;
import org.zerock.myProject.domain.BoardVO;
import org.zerock.myProject.domain.Criteria;
import org.zerock.myProject.mapper.BoardAttachMapper;
import org.zerock.myProject.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService{

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private final BoardMapper mapper;

	@Setter(onMethod_= @Autowired )
	private BoardAttachMapper attachMapper;

	@Transactional
	@Override
	public void register(BoardVO board) {

		log.info("register........." + board);

		mapper.insertSelectKey(board);

		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}

		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}


	@Override
	public BoardVO get(Long bno) {	
		
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {

		log.info("modify..........." + board);

		attachMapper.deleteAll(board.getBno());

		boolean modifyResult = mapper.update(board) == 1;

		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0){
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {

		log.info("remove............" + bno);

		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		List<BoardVO> list = mapper.getListWithPaging(cri);

		for (BoardVO board : list) {
			int replyCnt = mapper.getReplyCnt(board.getBno()); // 게시물의 댓글 수 조회
			board.setReplyCnt(replyCnt); // 댓글 수 설정
		}

		return list;
	}

	@Override
	public int getTotal(Criteria cri) {

		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map) {

		return mapper.searchTest(map);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {

		log.info("get Attach list by bno" + bno);

		return attachMapper.findByBno(bno);
	}


}
