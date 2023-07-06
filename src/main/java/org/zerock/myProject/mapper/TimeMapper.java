package org.zerock.myProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {

	@Select("select sysdate from dual")
	String getTime();
}
