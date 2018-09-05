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
	
	/**
	 * To get all category from database
	 * @return list of category
	 */
    public List<Category> getAllCategories() {
    	List<Category> categoryList = new ArrayList<Category>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToGetCategorys = connectionInstance.prepareStatement(CategoryQuery.GET_ALL_CATEGORY);) {
            	
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
    
    /**
	 * To add category in database
	 * @param category
	 * @return 1 if add successfully, 0 if add failed and -1 if error 
	 */
    public int addCategory(Category category) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddCategory = connectionInstance.prepareStatement(CategoryQuery.ADD_CATEGORY);) {
            	
    		preparedStatementToAddCategory.setString(1, category.getName());
    		return preparedStatementToAddCategory.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return -1;
    	}
    }
    
    /**
     * To delete category from database by categoryId
     * @param categoryId
     * @return 1 if delete successfully, 0 if delete failed and -1 if error 
     */
    public int deleteCategory(int categoryId) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToDeleteCategory = connectionInstance.prepareStatement(CategoryQuery.DELETE_CATEGORY);) {
            	
    		preparedStatementToDeleteCategory.setInt(1, categoryId);
    		return preparedStatementToDeleteCategory.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("error "+sqlException.toString());
            return -1;
    	}
    }

    /**
     * To update categoryName in database
     * @param categoryName1 update to
     * @param categoryName2 initial value
     * @return -1 if error, 0 if update failed and update successfully 
     */
    public int updateCategoryName(String categoryName1, String categoryName2) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToUpdateCategory = connectionInstance.prepareStatement(CategoryQuery.UPDATE_CATEGORY_NAME);) {
            	
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
