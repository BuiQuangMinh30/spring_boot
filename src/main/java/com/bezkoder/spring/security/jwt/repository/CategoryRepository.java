package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
