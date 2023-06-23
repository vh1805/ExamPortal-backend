package com.Sprinhboot.ExamPortal.service;

import com.Sprinhboot.ExamPortal.entity.Category;

import java.util.List;
public interface CategoryService {
    public Category addCategory(Category category);
    public List<Category> getAllCategory();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);

    public Category updateCategory(Category category);
}
