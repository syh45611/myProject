package org.zerock.myProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.myProject.domain.Criteria;
import org.zerock.myProject.domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);	// 특정 댓글 읽기
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	public int getCountByBno(Long bno);
	
	
}
