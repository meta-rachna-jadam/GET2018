package com.controller;

import java.util.List;

import com.facade.CategoryFacade;
import com.model.Category;

public class CategoryConroller {

	CategoryFacade categoryFacade;
    public CategoryConroller() {
    	categoryFacade = new CategoryFacade();
    }
    
    public List<Category> getAllCategories() {
    	return categoryFacade.getAllCategories();
    }
    
    public int addCategory(Category category) {
    	return categoryFacade.addCategory(category);
    }
    
    public int deleteCategoryById(int categoryId) {
    	return categoryFacade.deleteCategoryById(categoryId);
    }
    
    public int updateCategoryName(String categoryName1, String categoryName2){
    	return categoryFacade.updateCategoryName(categoryName1, categoryName2);
    }
}
