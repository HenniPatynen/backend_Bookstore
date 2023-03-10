package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;





@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log =LoggerFactory.getLogger(BookstoreApplication.class);

	@Autowired
	BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner CategoryData(CategoryRepository categoryRepository) {
		return(args)->{
			log.info("save categories");
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Romance"));
		
			
			log.info("show categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}*/
	@Bean
	public CommandLineRunner BookstoreData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return(args)->{
			log.info("save categories");
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Romance"));
			
			log.info("save some books");
			bookRepository.save(new Book("A Farewell to Arms","Ernest Hemmingway", 1929 ,"123123123-21", 10.0));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945,"221332112-5", 20.0));
			
			
			log.info("tulostetaan kirjat");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}

