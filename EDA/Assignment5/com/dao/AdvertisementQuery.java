package com.dao;

public class AdvertisementQuery {

    public static final String ADD_ADVERTISEMENT = "INSERT INTO advertisement (advertisementTitle, advertisementDESC, categoryId) VALUES (?, ?, ?)";
    
    public static final String GET_ALL_ADVERTISEMENT = "SELECT advertisementId, advertisementTitle, advertisementDESC, categoryId from advertisement";
    
    public static final  String GET_ALL_ADVERTISEMENT_BY_CATEGORY_ID = "SELECT advertisementId, advertisementTitle, advertisementDESC "
    		                                                + "FROM advertisement WHERE categoryId = ?";
    
    public final static String DELETE_ADVERTISEMENT_BY_ID = "DELETE FROM advertisement WHERE advertisementId = ?";
    
    public final static String UPDATE_ADVERTISEMENT = "UPDATE advertisement SET advertisementTitle = ? WHERE advertisementTitle = ? ";
}
