package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.Books;

import java.util.List;

public interface BookService {
    // Save operation
    Books save(Books books) ;

    // Read operation
    List<Books> getList();

    // Update operation
    Books updateBook(Books books,
                           Integer bookId);

    // Delete operation
    void deleteBook(Integer bookId);
}
