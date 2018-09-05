package com.facade;

import java.util.List;

import com.dao.AdvertisementDao;
import com.model.Advertisement;

public class AdvertisementFacade {

	private AdvertisementDao advertisementDao;
    public AdvertisementFacade() {
        advertisementDao = new AdvertisementDao();
    }
    
    /**
	 * To add advertisement in database
	 * @param advertisement
	 * @return 1 if add successfully, 0 if add failed and -1 if error 
	 */
    public int addAdvertisement(Advertisement advertisement)  {
        return advertisementDao.addAdvertisement(advertisement);
    }
    
    /**
	 * To get all advertisements from database
	 * @return list of advertisements
	 */
    public List<Advertisement> getAllAdvertisements() {
    	return advertisementDao.getAllAdvertisements();
    }
    
    /**
     * To get all advertisements from database by categoryId
     * @param categoryId
     * @return list of advertisements
     */
    public List<Advertisement> getAllAdvertisementByCategoryId(int categoryId) {
    	return advertisementDao.getAllAdvertisementByCategoryId(categoryId);
    } 
    
    /**
     * To delete advertisement from database by advertisementId
     * @param advertisementId
     * @return 1 if delete successfully, 0 if delete failed and -1 if error 
     */
    public int deleteAdvertisementById(int advertisementId) {
    	return advertisementDao.deleteAdvertisementById(advertisementId);
    } 
    
    /**
     * To update advertisementTitle in database
     * @param advertisementTitle1 update to
     * @param advertisementTitle2 initial value
     * @return -1 if error, 0 if update failed and else update successfully
     */
    public int updateAdvertisementByTitle(String advertisementTitle1, String advertisementTitle2) {
    	return advertisementDao.updateAdvertisementByTitle(advertisementTitle1, advertisementTitle2);
    } 
}
