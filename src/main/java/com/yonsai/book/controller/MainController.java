package com.yonsai.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		
		return "main/main";
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "main/main";
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
