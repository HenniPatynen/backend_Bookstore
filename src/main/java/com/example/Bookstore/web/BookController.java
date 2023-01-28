package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@GetMapping("index")
	@ResponseBody
	private String palautaTexti() {
		return "Tämä sivusto kehittää kurssin edetessä";
	}
	

	
}
