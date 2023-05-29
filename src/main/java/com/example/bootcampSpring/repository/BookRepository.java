package com.example.bootcampSpring.repository;

import com.example.bootcampSpring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Extendemos del repositorio de JPA para realizar mas facil las conexiones a nuestra base de datos relacional
                                    //nombre de la clase,   llave primaria de la base de datos( id de la clase Book)
public interface BookRepository extends JpaRepository<Book, Long> {
}
