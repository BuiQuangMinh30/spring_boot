package com.bezkoder.spring.security.jwt.security.services;


import com.bezkoder.spring.security.jwt.models.Books;
import com.bezkoder.spring.security.jwt.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class BooksService implements  BookService{
    @Autowired
    private BooksRepository repo;

    public BooksService (BooksRepository repo) {
        this.repo = repo;
    }
    @Override
    public Books save(Books books)
    {
        return repo.save(books);
    }

    @Override
    public List<Books> getList() {
        return (List<Books>)
                repo.findAll();
    }

    public Books get(Integer id) {
        return repo.findById(id).get();
    }

    public Books updateBook(Books book,
                     Integer bookId)
    {
        Books books
                = repo.findById(bookId)
                .get();

        if (Objects.nonNull(book.getName())
                && !"".equalsIgnoreCase(
                book.getName())) {
            books.setName(
                    book.getName());
        }
        if(Objects.nonNull(book.getDescription())&& !"".equalsIgnoreCase((book.getDescription()))){
            books.setDescription(book.getDescription());
        }
        if(Objects.nonNull(books.getPrice())){
            books.setPrice(book.getPrice());
        }

        if(Objects.nonNull(book.getAddress_id())){
            books.setAddress_id(book.getAddress_id());
        }


        return repo.save(books);
    }

    @Override
    public void deleteBook(Integer bookId) {
        repo.deleteById(bookId);
    }


}
