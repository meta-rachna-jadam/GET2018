package com.dao;

public class AdvertisementQuery {

    public static final String addAdvertisement = "INSERT INTO advertisement (advertisementTitle, advertisementDESC, categoryId) VALUES (?, ?, ?)";
    
    public static final String getAllAdvertisement = "SELECT advertisementId, advertisementTitle, advertisementDESC, categoryId from advertisement";
    
    public static final  String getAllAdvertisementByCategoryId = "SELECT advertisementId, advertisementTitle, advertisementDESC "
    		                                                + "FROM advertisement WHERE categoryId = ?";
    
    public final static String DELETE_ADVERTISEMENT_BY_ID = "DELETE FROM advertisement WHERE advertisementId = ?";
    
    public final static String UPDATE_ADVERTISEMENT = "UPDATE advertisement SET advertisementTitle = ? WHERE advertisementTitle = ? ";
}
