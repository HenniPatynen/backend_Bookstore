package com.example.Bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	private static final Logger log =LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value= {"/main"})
	public String ShowMainPage() {
		return "index";
	}
	
	@RequestMapping(value= {"/booklist", "/"})
	public String showBooklist(Model model) {
		log.info("get books from database");
		model.addAttribute("books", bookRepository.findAll());
		return "bookList";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return " redirect:/bookList";
	}
	

	
}
