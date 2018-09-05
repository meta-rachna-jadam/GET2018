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
	 * @return
	 */
    public int addAdvertisement(Advertisement advertisement) {
        try (
	        Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddAdvertisement = connectionInstance.prepareStatement(AdvertisementQuery.addAdvertisement);) {
        	
            preparedStatementToAddAdvertisement.setString(1, advertisement.getTitle());
            preparedStatementToAddAdvertisement.setString(2, advertisement.getDescription());
            preparedStatementToAddAdvertisement.setInt(3, advertisement.getCategoryId());
    	    return preparedStatementToAddAdvertisement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
    	    return -1;
	    }
    }
    
    public List<Advertisement> getAllAdvertisements() {
    	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToGetAdvertisements = connectionInstance.prepareStatement(AdvertisementQuery.getAllAdvertisement);) {
            	
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
    
    public List<Advertisement> getAllAdvertisementByCategoryId(int categoryId) {
    	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(DBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToGetAdvertisements = 
                connectionInstance.prepareStatement(AdvertisementQuery.getAllAdvertisementByCategoryId);) {
    		
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
