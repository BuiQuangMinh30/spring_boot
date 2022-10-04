package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.Books;
import com.bezkoder.spring.security.jwt.models.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category) ;

    // Read operation
    List<Category> getList();

    Category get(Integer id);

    // Update operation
    Category updateCategory(Category category,
                     Integer cateId);

    // Delete operation
    void deleteCategory(Integer cateId);


}
