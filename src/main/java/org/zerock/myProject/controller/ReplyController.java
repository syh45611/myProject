package org.zerock.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.myProject.domain.Criteria;
import org.zerock.myProject.domain.ReplyPageDTO;
import org.zerock.myProject.domain.ReplyVO;
import org.zerock.myProject.service.ReplyService;

import lombok.AllArgsConstructor;

@RequestMapping("/replies/")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class ReplyController {
	@Autowired
	private ReplyService service;

	// 댓글 등록 처리
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		
		System.out.println("ReplyVO: " + vo);
		
		int insertCount = service.register(vo);
		
		System.out.println("Reply Insert Count: " + insertCount);
		
		// 삼항 연산자 처리
		return insertCount == 1 ? 
					new ResponseEntity<>("success", HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
				
	}
	// 댓글 목록 조회 처리
	@GetMapping(value = "/pages/{bno}/{page}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") String page, @PathVariable("bno") Long bno) {

		if (page.endsWith(".json")) {
			page = page.substring(0, page.length() - 5); // .json 제거
		}

		int pageNumber = Integer.parseInt(page); // String을 int로 변환

		Criteria cri = new Criteria(pageNumber, 10);

		System.out.println("get ReplyList bno: " + bno);
		System.out.println("cri:" + cri);

		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	// 특정 댓글 조회 처리
	@GetMapping(value = "/{rno}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		System.out.println("get.." + rno);
		ReplyVO reply = service.get(rno);
		if (reply != null) {
			return new ResponseEntity<>(reply, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// 댓글 삭제 처리
	@DeleteMapping(value = "/{rno}",
				   produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
			
			System.out.println("remove.." + rno);
			
			return service.remove(rno) == 1 ? 
							new ResponseEntity<>("success", HttpStatus.OK)
						:   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
						
	}
	// 댓글 수정 처리
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH },
				    value = "/{rno}",
				    consumes = "application/json",
				    produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
										 @PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		System.out.println("rno:" + rno);
		
		System.out.println("modify: " + vo);
		
		return service.modify(vo) == 1 ?
							new ResponseEntity<>("success", HttpStatus.OK)
						:   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
