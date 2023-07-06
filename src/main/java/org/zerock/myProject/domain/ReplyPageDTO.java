package org.zerock.myProject.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReplyPageDTO {
	
	private int replyCnt;
	private List<ReplyVO> list;
}
