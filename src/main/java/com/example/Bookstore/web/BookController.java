package com.example.Bookstore.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {
	
	@GetMapping("index")
	@ResponseBody
	private String palautaTexti() {
		return "Tämä sivusto kehittää kurssin edetessä";
	}
	

	
	@Bean
	public CommandLineRunner books(Book book) {
		return(args)->{
			
		};
	}

	
}
