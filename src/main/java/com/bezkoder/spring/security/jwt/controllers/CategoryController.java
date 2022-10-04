package com.bezkoder.spring.security.jwt.controllers;

import com.bezkoder.spring.security.jwt.models.Books;
import com.bezkoder.spring.security.jwt.models.Category;
import com.bezkoder.spring.security.jwt.repository.CategoryRepository;
import com.bezkoder.spring.security.jwt.security.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;


@Controller
@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/v1/category")

public class CategoryController {
    @Autowired
    public CategoryRepository repo;

    @Autowired
    public CategoryService service;


    // Save operation
    @PostMapping("")
    public Category save(
            @Valid @RequestBody Category category)
    {
        return service.save(category);
    }

    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')" )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = service.get(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }


    // Update operation
    @PutMapping("/{id}")
    public Category updateCategory(@Valid @RequestBody Category category, @PathVariable Integer id){
        return service.updateCategory(category,id);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return "Deleted Successfully";
    }


}
