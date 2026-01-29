package com.yonsai.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yonsai.book.dto.BookDTO;
import com.yonsai.book.service.BookService;


/**
 * 메인 페이지 노출과 책 관련 CRUD 처리 요청을 받는 컨트롤러
 *  역할: 
 *    - 메인페이지 노출함.
 *    - 책 정보의 CRUD 처리 요청 수신함.
 *    - 실제 비지니스 로직은 service로 위임.
 */

@Controller
public class MainController {
	
	@Autowired
	private BookService bookService;

	
	/**
	 * 메인 페이지 연결 메서드
	 *  TODO: DB에서 조회한 책 리스트 테이블 형태로 노출함.
	 */
	@GetMapping("/")
	public String main() {
		
		return "main/main";
	}
	
	/**
	 * 도서 등록 페이지 연결 메서드
	 *  - form 형태의 입력창을 제공함.
	 */
	@GetMapping("/add")
	public String add() {
		return "main/add";
	}
	
	/**
	 * 도서 등록 처리 메서드
	 *  - 입력받은 도서 정보를 DB에 저장함.
	 *  @param BookDTO 객체
	 *  @return 메인 페이지로 리다이렉트
	 */
	@PostMapping("/add")
	public String addPro(BookDTO book) {
		
		bookService.saveBook(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update() {
		
		return "main/main";
	}
	
	@GetMapping("/select")
	public String select() {
		
		return "main/main";
	}
}
