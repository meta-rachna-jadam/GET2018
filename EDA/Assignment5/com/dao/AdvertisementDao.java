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
            PreparedStatement preparedStatementToAddAdvertisements = connectionInstance.prepareStatement(AdvertisementQuery.getAllAdvertisement);) {
            	
            ResultSet advertisementResultSet = preparedStatementToAddAdvertisements.executeQuery();
            while (advertisementResultSet.next()) {
            	advertisementList.add(new Advertisement(advertisementResultSet.getString("advertisementTitle"), 
            	    advertisementResultSet.getString("advertisementDESC"), advertisementResultSet.getInt("categoryId")));
            }
            return advertisementList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
    	}
    }

}
