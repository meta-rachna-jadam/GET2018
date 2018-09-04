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
}
