package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.controller.AdvertisementController;
import com.google.gson.Gson;
import com.model.Advertisement;
import com.model.CustemException;

@Path("advertisement")
public class AdvertisementResource {
	
	private final String errorMessage = "Error: 401 Unauthorized Access";
	private final String authorization = "GET-2018";
	private int id;
	private Gson gson = new Gson();
	
	@GET
	@Path("getAdvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdvertisement(@HeaderParam("Authorization") String authorizationString) {
		if (!authorization.equals(authorizationString)) {
			return errorMessage;
		}
		List<Advertisement> advertisementList = new AdvertisementController().getAllAdvertisements();
		return gson.toJson(advertisementList);
	}
	
	@GET
    @Path("/getAdvertismentByCategory/{categoryID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAdvertisementsByCategory(@PathParam("categoryID") String categoryID, @HeaderParam("Authorization") String authorizationString) 
    {
        if(!authorization.equals(authorizationString))
        {
            return errorMessage;
        }
        id=-1;
        try {
            id = Integer.parseInt(categoryID);
        }catch (NumberFormatException numberFormatException) {
        	new CustemException("AdvertisementResource", numberFormatException.toString(), numberFormatException.getMessage());
        	System.exit(1);
        }
        List<Advertisement> advertismentList = 
                new AdvertisementController().getAllAdvertisementByCategoryId(id);
        return gson.toJson(advertismentList);
    }
    
    @POST
    @Path("/addAdvertisement")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addAdvertisement(String advertisementInput, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        Advertisement advertisement = gson.fromJson(advertisementInput, Advertisement.class);
        return (new AdvertisementController().addAdvertisement(advertisement) > 0);
    }
    
    @DELETE
    @Path("/deleteAdvertisement/{advertisementID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteAdvertisement(@PathParam("advertisementID") String advertisementID, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        id=-1;
        try {
            id = Integer.parseInt(advertisementID);
        }catch (NumberFormatException numberFormatException) {
        	new CustemException("AdvertisementResource", numberFormatException.toString(), numberFormatException.getMessage());
        	System.exit(1);
        }
        return (new AdvertisementController().deleteAdvertisementById(id) > 0);
    }
    
    @PUT
    @Path("/updateAdvertisement")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String advertisementTitles, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        if (advertisementTitles.contains(" to ")){
        	String[] advertisementTitle = advertisementTitles.split(" to ");
        	return (new AdvertisementController().updateAdvertisementByTitle(advertisementTitle[1], advertisementTitle[0]) > 0);
        } else {
        	new CustemException("AdvertisementResource", "to is not present in given string", "to is not present in given string");
        }
        return false;
    }
}
