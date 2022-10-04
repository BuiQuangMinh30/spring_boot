package com.bezkoder.spring.security.jwt.controllers;


import com.bezkoder.spring.security.jwt.models.Books;
import com.bezkoder.spring.security.jwt.repository.BooksRepository;
import com.bezkoder.spring.security.jwt.security.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/v1/books")

public class BooksController {
    @Autowired
    public BooksService service;
    @Autowired
    public BooksRepository booksRepository;


    // Save operation
    @PostMapping("")
    public Books save(
            @Valid @RequestBody Books department)
    {
        return service.save(department);
    }

    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')" )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(booksRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> get(@PathVariable Integer id) {
        try {
            Books books = service.get(id);
            return new ResponseEntity<Books>(books, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
    }


    // Update operation
    @PutMapping("/{id}")
    public Books updateBook(@Valid @RequestBody Books books, @PathVariable Integer id){
        return service.updateBook(books,id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteBook(id);
        return "Deleted Successfully";
    }



}
