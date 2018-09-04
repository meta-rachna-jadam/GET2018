package com.dao;

public class AdvertisementQuery {

    public static String addAdvertisement = "INSERT INTO advertisement (advertisementTitle, advertisementDESC, categoryId) VALUES (?, ?, ?)";
    
    public static String getAllAdvertisement = "SELECT advertisementTitle, advertisementDESC, categoryId from advertisement";
}
