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
    
    public int addCategory(Category category) {
    	return categoryDao.addCategory(category);
    }
    
    public int deleteCategoryById(int categoryId) {
    	return categoryDao.deleteCategory(categoryId);
    }
    
    public int updateCategoryName(String categoryName1, String categoryName2){
    	return categoryDao.updateCategoryName(categoryName1, categoryName2);
    }

}
