package com.example.bootcampSpring.controller;

import com.example.bootcampSpring.entities.Book;
import com.example.bootcampSpring.repository.BookRepository;
import org.slf4j.Logger; //slf4j este es el import de Logger para Java
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Esta es nuestra clase que va a tener nuestros controladores HTTP
@RestController
public class BookController {
    //atribuos
    private final Logger log = LoggerFactory.getLogger(BookController.class); //Esta linea nos permite mostrar mensajes de errores
    private BookRepository bookRepository;

    //constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //getter y setter
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    /**
     * Request
     * Response
     *
     * @param id
     * @return
     **/
    //Buscar un solo libros en base de datos segun su id
    @GetMapping("api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);

        //Opcion 1
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

        //Opcion 2
        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //       }
    }
//Crear libro en BD
@PostMapping("/api/books")
//El RequestBody le dice al objeto Book que le cargue al Repositorio la peticion de un objeto de tipo book(Nuestros libros creados)
    public ResponseEntity<Object> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
    System.out.println(headers.get("User-Agent"));
    //Guardar el libro recibido en la BD
    if(book.getId() != null){
        log.warn("trying to create a book with id");
        System.out.println("trying to create a book with id");
        return ResponseEntity.badRequest().build();
    }
    Book result = bookRepository.save(book);
    return ResponseEntity.ok(result);  //el libro devuelto tiene una clave primaria
    }


//Actualizar libro en BD
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){ //Si no tiene id quiere decir que si es una creacion
            log.warn("Tryin to update a non exist book");
            return ResponseEntity.badRequest().build();
                }

        if(!bookRepository.existsById(book.getId())) {
            log.warn("Tryin to update a non exist book");
            return ResponseEntity.notFound().build();
        }
            //El proceso de actualizacion
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); //El libro devuelto tiene una clave primaria
    }


    //Borrar un libro en BD
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book>delete(@PathVariable Long id){

        if(!bookRepository.existsById(id)){
            log.warn("Tryin to update a non exist book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Borrar todos los libros de la BD
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> DeleteAll(){
        log.info("REST request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.notFound().build();
    }



    }

