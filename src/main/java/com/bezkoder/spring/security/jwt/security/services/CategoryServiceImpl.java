package com.bezkoder.spring.security.jwt.security.services;


import com.bezkoder.spring.security.jwt.models.Category;
import com.bezkoder.spring.security.jwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Category save(Category category)
    {
        return repo.save(category);
    }

    @Override
    public List<Category> getList() {
        return (List<Category>)
                repo.findAll();
    }


    @Override
    public Category get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Category updateCategory(Category cate,
                            Integer bookId)
    {
        Category cateDB
                = repo.findById(bookId)
                .get();

        if (Objects.nonNull(cate.getName())
                && !"".equalsIgnoreCase(
                cate.getName())) {
            cateDB.setName(
                    cate.getName());
        }
        return repo.save(cate);
    }


    @Override
    public void deleteCategory(Integer cateId) {
        repo.deleteById(cateId);
    }
}
