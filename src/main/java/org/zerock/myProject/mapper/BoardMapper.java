package org.zerock.myProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.myProject.domain.BoardVO;
import org.zerock.myProject.domain.Criteria;

@Mapper
public interface BoardMapper {

	List<BoardVO> getList();
	
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO board);
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);

	void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);

	int getReplyCnt(Long bno);
}
