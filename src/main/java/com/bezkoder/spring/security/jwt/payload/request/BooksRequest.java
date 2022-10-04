package com.bezkoder.spring.security.jwt.payload.request;

import com.bezkoder.spring.security.jwt.models.Books;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.print.Book;
import java.util.List;
import java.util.Set;

public class BooksRequest {
    @NotBlank
    private int id;

    @NotBlank
    @Size(max = 50)
    @Email
    private String name;

    @NotBlank
    @Size(min = 6, max = 40)
    private String description;

    @NotBlank
    private int price;

    @NotBlank
    private int address_id;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public Books getBook(){
        Books books = new Books();
        books.setId(this.getId());
        books.setName(this.getName());
        books.setDescription(this.getDescription());
        books.setPrice(this.getPrice());

        return books;
    }


}
