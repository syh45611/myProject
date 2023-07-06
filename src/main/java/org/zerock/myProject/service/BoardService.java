package org.zerock.myProject.service;

import java.util.List;
import java.util.Map;

import org.zerock.myProject.domain.BoardAttachVO;
import org.zerock.myProject.domain.BoardVO;
import org.zerock.myProject.domain.Criteria;

public interface BoardService {

	void register(BoardVO board);
	
	BoardVO get(Long bno);
	
	boolean modify(BoardVO board);
	
	boolean remove(Long bno);
	
	List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);
	
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);

	List<BoardAttachVO> getAttachList(Long bno);

}
