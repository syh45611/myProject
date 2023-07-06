package org.zerock.myProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myProject.domain.Criteria;
import org.zerock.myProject.domain.ReplyPageDTO;
import org.zerock.myProject.domain.ReplyVO;
import org.zerock.myProject.mapper.BoardMapper;
import org.zerock.myProject.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Transactional
	@Override
	public int register(ReplyVO vo){

		System.out.println("register......" + vo);

		boardMapper.updateReplyCnt(vo.getBno(), 1);

		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
	
		System.out.println("get......." + rno);
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		System.out.println("modify......." + vo);
		
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		
		System.out.println("remove......." + rno);

		ReplyVO vo = mapper.read(rno);

		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		
		System.out.println("get Reply List of a Board" + bno);
		
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}




	
}
