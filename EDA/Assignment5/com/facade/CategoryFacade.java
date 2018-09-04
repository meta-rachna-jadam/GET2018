package com.facade;

import java.util.List;

import com.dao.CategoryDao;
import com.model.Category;

public class CategoryFacade {
	
	CategoryDao categoryDao;
    public CategoryFacade() {
    	categoryDao = new CategoryDao();
    }
    
    public List<Category> getAllCategories() {
    	return categoryDao.getAllCategories();
    }

}
