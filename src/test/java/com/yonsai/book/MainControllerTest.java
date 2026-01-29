package com.yonsai.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.yonsai.book.entity.Book;
import com.yonsai.book.repository.BookRepository;


@SpringBootTest			// 테스트 서버 실행
@AutoConfigureMockMvc 	// url 요청과 응답을 흉내냄
public class MainControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * 메인 화면 요청 컨트롤러 테스트
	 *  검사 조건
	 *   - "/" 요청의 상태값이 200인지
	 *   - 뷰 페이지 이동이 main인지
	 *   @throws Exception MockMvc의 perform 메서드 실행 시 발생할 수 있는 예외
	 */
	@Test
	void 메인_컨트롤러_실행_테스트() throws Exception{
		mock.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("main/main"));
	}
	
	/**
	 * 도서 등록 요청 컨트롤러 테스트
	 * 검사 조건:
	 * 	- POST "/add" 요청 시 성공적으로 리다이렉트 되는지 (302 Redirect)
	 *  - 리다이렉트 되는 뷰 이름이 "redirect:/main"인지
	 *  - 데이터베이스에 전달한 파라미터와 동일한 값이 저장되었는지
	 *  @throws Exception MockMvc의 perform 메서드 실행 시 발생할 수 있는 예외
	 * 
	 */
	@Transactional
	@Test
	void 도서_등록_실행_테스트() throws Exception{
		// When: 도서 등록 요청 실행
		mock.perform(post("/add")
				.param("title", "test title")
				.param("author", "test author")
				.param("price", "15000"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/"));
		
		// Then: DB 저장 상태 검증
		List<Book> allBooks = bookRepository.findAll();
		assertThat(allBooks).isNotEmpty();
		
		Book savedBook = allBooks.get(allBooks.size() - 1); // 가장 마지막에 저장된 객체
		assertThat(savedBook.getTitle()).isEqualTo("test title");
		assertThat(savedBook.getAuthor()).isEqualTo("test author");
		assertThat(savedBook.getPrice()).isEqualByComparingTo(new BigDecimal("15000"));
		
	}
	
}
