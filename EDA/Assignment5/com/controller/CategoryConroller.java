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
}
