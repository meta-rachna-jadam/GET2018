package com.dao;

public class CategoryQuery {

	public static String addCategory = "INSERT INTO category (categoryName) VALUES (?)";
	public static String getAllCategory = "SELECT categoryId, categoryName FROM category";
}
