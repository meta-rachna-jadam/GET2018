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
            PreparedStatement preparedStatementToGetCategorys = connectionInstance.prepareStatement(CategoryQuery.getAllCategory);) {
            	
            ResultSet categoryResultSet = preparedStatementToGetCategorys.executeQuery();
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
    
    public int addCategory(Category category) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddCategory = connectionInstance.prepareStatement(CategoryQuery.addCategory);) {
            	
    		preparedStatementToAddCategory.setString(1, category.getName());
    		return preparedStatementToAddCategory.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return -1;
    	}
    }
    
    public int deleteCategory(int categoryId) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToDeleteCategory = connectionInstance.prepareStatement(CategoryQuery.deleteCategory);) {
            	
    		preparedStatementToDeleteCategory.setInt(1, categoryId);
    		return preparedStatementToDeleteCategory.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return -1;
    	}
    }

    public int updateCategoryName(String categoryName1, String categoryName2) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToUpdateCategory = connectionInstance.prepareStatement(CategoryQuery.updateCategoryName);) {
            	
    		preparedStatementToUpdateCategory.setString(1, categoryName1);
    		preparedStatementToUpdateCategory.setString(2, categoryName2);
    		return preparedStatementToUpdateCategory.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return -1;
    	}
    }
}
