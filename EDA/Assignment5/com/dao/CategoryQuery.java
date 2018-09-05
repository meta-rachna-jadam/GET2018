package com.dao;

public class CategoryQuery {

    public static final String addCategory = "INSERT INTO category (categoryName) VALUES (?)";
    public static final String getAllCategory = "SELECT categoryId, categoryName FROM category";
    public static final String deleteCategory = "DELETE FROM category WHERE categoryId = ?";
    public static final String updateCategoryName = "UPDATE category SET categoryName = ? WHERE categoryName = ? ";
}
