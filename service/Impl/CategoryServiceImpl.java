package com.Sprinhboot.ExamPortal.service.Impl;

import com.Sprinhboot.ExamPortal.entity.Category;
import com.Sprinhboot.ExamPortal.repository.CategoryRepository;
import com.Sprinhboot.ExamPortal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        categoryRepository.delete(category);

    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
