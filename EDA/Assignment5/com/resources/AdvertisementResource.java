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

@Path("advertisement")
public class AdvertisementResource {
	
	@GET
	@Path("getAdvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdvertisement(@HeaderParam("Authorization") String authorizationString) {
		if (!"GET-2018".equals(authorizationString)) {
			return "Error: 401 Unauthorized Access";
		}
		List<Advertisement> advertisementList = new AdvertisementController().getAllAdvertisements();
		Gson gson = new Gson();
		return gson.toJson(advertisementList);
	}
	
	@GET
    @Path("/getAdvertismentByCategory/{categoryID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAdvertisementsByCategory(@PathParam("categoryID") String categoryID, @HeaderParam("Authorization") String authorizationString) 
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return "Error: 401 Unauthorized Access";
        }
        int id = Integer.parseInt(categoryID);
        List<Advertisement> advertismentList = 
                new AdvertisementController().getAllAdvertisementByCategoryId(id);
        Gson gson = new Gson();
        return gson.toJson(advertismentList);
    }
    
    @POST
    @Path("/addAdvertisement")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addAdvertisement(String advertisementInput, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        Gson g = new Gson();
        Advertisement advertisement = g.fromJson(advertisementInput, Advertisement.class);
        boolean result = (new AdvertisementController().addAdvertisement(advertisement) > 0);
        return result;
    }
    
    @DELETE
    @Path("/deleteAdvertisement/{advertisementID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteAdvertisement(@PathParam("advertisementID") String advertisementID, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        int id = Integer.parseInt(advertisementID);
        boolean result = (new AdvertisementController().deleteAdvertisementById(id) > 0);
        return result;
    }
    
    @PUT
    @Path("/updateAdvertisement")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String advertisementTitles, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        String[] advertisementTitle = advertisementTitles.split(" to ");
        boolean result = (new AdvertisementController().updateAdvertisementByTitle(advertisementTitle[1], advertisementTitle[0]) > 0);
        return result;
    }
}
