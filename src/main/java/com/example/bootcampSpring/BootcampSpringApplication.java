package com.example.bootcampSpring;

import com.example.bootcampSpring.entities.Book;
import com.example.bootcampSpring.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.time.LocalDate;
import com.example.bootcampSpring.controller.BookController;

@SpringBootApplication
public class BootcampSpringApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(BootcampSpringApplication.class, args);
	BookRepository repository = context.getBean(BookRepository.class);
	//CRUD
		//CREAR LIBRO
		Book book1 = new Book(null, "Principito", "Amadeo", 200, 20.99, LocalDate.of(2020, 2, 1), true);
		Book book2 = new Book(null, "titulo", "String", 250, 20.99, LocalDate.of(2020, 2, 1), true);
	//Almacenamos el libro
		System.out.println("Numero de libros totales en la base de datos:" + repository.findAll().size());

		repository.save(book1);
		repository.save(book2);

		//Recuperamos todos los libros
		System.out.println("Numero de libros totales en la base de datos:" + repository.findAll().size());

		//Borramos uno de los libros
		//repository.deleteById(1L);
		System.out.println("Numero de libros totales en la base de datos:" + repository.findAll().size());



	}
}
