package com.dao;

public class CategoryQuery {

    public static final String ADD_CATEGORY = "INSERT INTO category (categoryName) VALUES (?)";
    public static final String GET_ALL_CATEGORY = "SELECT categoryId, categoryName FROM category";
    public static final String DELETE_CATEGORY = "DELETE FROM category WHERE categoryId = ?";
    public static final String UPDATE_CATEGORY_NAME = "UPDATE category SET categoryName = ? WHERE categoryName = ? ";
}
