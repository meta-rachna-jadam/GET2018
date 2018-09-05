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
    public List<Advertisement> getAllAdvertisementByCategoryId(int categoryId) {
    	return advertisementDao.getAllAdvertisementByCategoryId(categoryId);
    } 
    public int deleteAdvertisementById(int advertisementId) {
    	return advertisementDao.deleteAdvertisementById(advertisementId);
    } 
    public int updateAdvertisementByTitle(String advertisementTitle1, String advertisementTitle2) {
    	return advertisementDao.updateAdvertisementByTitle(advertisementTitle1, advertisementTitle2);
    } 
}
