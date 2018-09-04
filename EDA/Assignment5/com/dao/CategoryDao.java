package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.constant.DBConstants;
import com.model.Category;

public class CategoryDao {
	
    public List<Category> getAllCategories() {
    	List<Category> categoryList = new ArrayList<Category>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddAdvertisements = connectionInstance.prepareStatement(CategoryQuery.getAllCategory);) {
            	
            ResultSet categoryResultSet = preparedStatementToAddAdvertisements.executeQuery();
            while (categoryResultSet.next()) {
            	categoryList.add(new Category(categoryResultSet.getInt("categoryId"), categoryResultSet.getString("categoryName")));
            }
            return categoryList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return null;
    	}
    }


}
