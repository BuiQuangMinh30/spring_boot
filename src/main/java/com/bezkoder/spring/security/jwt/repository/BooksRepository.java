package com.bezkoder.spring.security.jwt.repository;


import com.bezkoder.spring.security.jwt.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
