package com.yonsai.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonsai.book.dto.BookDTO;
import com.yonsai.book.entity.Book;
import com.yonsai.book.repository.BookRepository;
import com.yonsai.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;

	/**
	 * DB에 Book 객체를 저장하는 메서드
	 *  @param 사용자가 입력한 BookDTO 객체
	 *  @return 없음
	 */
	@Override
	public void saveBook(BookDTO dto) {
		Book book = Book.from(dto);
		if(book != null) {
			bookRepository.save(book);
		}
	}
}
