package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.constant.DBConstants;
import com.model.Advertisement;


public class AdvertisementDao {
	
	/**
	 * To add advertisement in database
	 * @param advertisement
	 * @return 1 if add successfully, 0 if add failed and -1 if error 
	 */
    public int addAdvertisement(Advertisement advertisement) {
        try (
	        Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddAdvertisement = connectionInstance.prepareStatement(AdvertisementQuery.ADD_ADVERTISEMENT);) {
        	
            preparedStatementToAddAdvertisement.setString(1, advertisement.getTitle());
            preparedStatementToAddAdvertisement.setString(2, advertisement.getDescription());
            preparedStatementToAddAdvertisement.setInt(3, advertisement.getCategoryId());
    	    return preparedStatementToAddAdvertisement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
    	    return -1;
	    }
    }
    
    /**
	 * To get all advertisements from database
	 * @return list of advertisements
	 */
    public List<Advertisement> getAllAdvertisements() {
    	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToGetAdvertisements = connectionInstance.prepareStatement(AdvertisementQuery.GET_ALL_ADVERTISEMENT);) {
            	
            ResultSet advertisementResultSet = preparedStatementToGetAdvertisements.executeQuery();
            while (advertisementResultSet.next()) {
            	advertisementList.add(new Advertisement(advertisementResultSet.getInt("advertisementId"), 
            	advertisementResultSet.getString("advertisementTitle"), advertisementResultSet.getString("advertisementDESC"),
            	advertisementResultSet.getInt("categoryId")));
            }
            return advertisementList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
    	}
    }
    
    /**
     * To get all advertisements from database by categoryId
     * @param categoryId
     * @return list of advertisements
     */
    public List<Advertisement> getAllAdvertisementByCategoryId(int categoryId) {
    	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToGetAdvertisements = 
                connectionInstance.prepareStatement(AdvertisementQuery.GET_ALL_ADVERTISEMENT_BY_CATEGORY_ID);) {
    		
    		preparedStatementToGetAdvertisements.setInt(1, categoryId);
            	
            ResultSet advertisementResultSet = preparedStatementToGetAdvertisements.executeQuery();
            while (advertisementResultSet.next()) {
            	advertisementList.add(new Advertisement(advertisementResultSet.getInt("advertisementId"), 
            	advertisementResultSet.getString("advertisementTitle"), advertisementResultSet.getString("advertisementDESC"), categoryId));
            }
            return advertisementList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
    	}
    }
    
    /**
     * To delete advertisement from database by advertisementId
     * @param advertisementId
     * @return 1 if delete successfully, 0 if delete failed and -1 if error 
     */
    public int deleteAdvertisementById(int advertisementId) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToDeleteAdvertisements = 
                connectionInstance.prepareStatement(AdvertisementQuery.DELETE_ADVERTISEMENT_BY_ID);) {
    		
    		preparedStatementToDeleteAdvertisements.setInt(1, advertisementId);
            	
            return preparedStatementToDeleteAdvertisements.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return -1;
    	}
    }
    
    /**
     * To update advertisementTitle in database
     * @param advertisementTitle1 update to
     * @param advertisementTitle2 initial value
     * @return -1 if error, 0 if update failed and else if error 
     */
    public int updateAdvertisementByTitle(String advertisementTitle1, String advertisementTitle2) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToUpadetAdvertisements = 
                connectionInstance.prepareStatement(AdvertisementQuery.UPDATE_ADVERTISEMENT);) {
    		
    		preparedStatementToUpadetAdvertisements.setString(1, advertisementTitle1);
    		preparedStatementToUpadetAdvertisements.setString(2, advertisementTitle2);
            	
            return preparedStatementToUpadetAdvertisements.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return -1;
    	}
    }
}
