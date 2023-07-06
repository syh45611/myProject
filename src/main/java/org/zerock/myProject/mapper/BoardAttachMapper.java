package org.zerock.myProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.myProject.domain.BoardAttachVO;

import java.util.List;

@Mapper
public interface BoardAttachMapper {

    void insert(BoardAttachVO vo);

    void delete(String uuid);

    List<BoardAttachVO> findByBno(Long bno);

    void deleteAll(Long bno);

    public List<BoardAttachVO> getOldFiles();

}
