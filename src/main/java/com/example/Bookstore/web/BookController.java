package com.example.Bookstore.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	private static final Logger log =LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value= {"/main"})
	public String ShowMainPage() {
		return "index";
	}
	
	//näytetään kirjalistaus
	@RequestMapping(value= {"/booklist", "/"})
	public String showBooklist(Model model) {
		log.info("get books from database");
		model.addAttribute("books", bookRepository.findAll());
		return "bookList";
	}
	
	//poistetaan rivitieto
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	//muokataan rivitietoa
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		return "editBook";
	}

	//lisätään rivi
	@GetMapping("/addBook")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	//tallennetaan muokkaus/lisäys  
	@PostMapping("/saveBook")
	public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	
	
}
