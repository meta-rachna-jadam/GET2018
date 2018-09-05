package com.controller;

import java.util.List;

import com.facade.AdvertisementFacade;
import com.model.Advertisement;

public class AdvertisementController {
	
    private AdvertisementFacade advertisementFacade;
    public AdvertisementController() {
        advertisementFacade = new AdvertisementFacade();
    }
    public int addAdvertisement(Advertisement advertisement)  {
        return advertisementFacade.addAdvertisement(advertisement);
    }
    
    public List<Advertisement> getAllAdvertisements() {
    	return advertisementFacade.getAllAdvertisements();
    }
    
    public List<Advertisement> getAllAdvertisementByCategoryId(int categoryId) {
    	return advertisementFacade.getAllAdvertisementByCategoryId(categoryId);
    } 
    public int deleteAdvertisementById(int advertisementId) {
    	return advertisementFacade.deleteAdvertisementById(advertisementId);
    } 
    public int updateAdvertisementByTitle(String advertisementTitle1, String advertisementTitle2) {
    	return advertisementFacade.updateAdvertisementByTitle(advertisementTitle1, advertisementTitle2);
    } 
}
