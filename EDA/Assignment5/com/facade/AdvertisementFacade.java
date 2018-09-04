package com.facade;

import java.util.List;

import com.dao.AdvertisementDao;
import com.model.Advertisement;

public class AdvertisementFacade {

	private AdvertisementDao advertisementDao;
    public AdvertisementFacade() {
        advertisementDao = new AdvertisementDao();
    }
    public int addAdvertisement(Advertisement advertisement)  {
        return advertisementDao.addAdvertisement(advertisement);
    }
    public List<Advertisement> getAllAdvertisements() {
    	return advertisementDao.getAllAdvertisements();
    }
}
