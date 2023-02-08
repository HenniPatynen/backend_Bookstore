package com.example.Bookstore.domain;



import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category category = new Category();
	
	private String findByName() {
		
		String name= category.getName();
		return name;
	}
}
