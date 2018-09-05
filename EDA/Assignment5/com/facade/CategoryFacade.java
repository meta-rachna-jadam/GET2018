package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.controller.AdvertisementController;
import com.controller.CategoryConroller;
import com.google.gson.Gson;
import com.model.Category;
import com.model.CustemException;

@Path("category")
public class CategoryResource {

	private final String errorMessage = "Error: 401 Unauthorized Access";
	private final String authorization = "GET-2018";
	private int id;
	private Gson gson = new Gson();
	
	@GET
	@Path("getCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdvertisement(@HeaderParam("Authorization") String authorizationString) {
		if (!authorization.equals(authorizationString)) {
			return errorMessage;
		}
		List<Category> categoryList = new CategoryConroller().getAllCategories();
		return gson.toJson(categoryList);
	}	
	
	@POST
    @Path("/addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addCategory(String categoryInput, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        Category category = gson.fromJson(categoryInput, Category.class);
        return  (new CategoryConroller().addCategory(category) > 0);
    }
    
    @DELETE
    @Path("/deleteCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteCategory(String categoryID, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        id=-1;
        try {
            id = Integer.parseInt(categoryID);
        }catch (NumberFormatException numberFormatException) {
        	new CustemException("CategoryResource", numberFormatException.toString(), numberFormatException.getMessage());
        	System.exit(1);
        }
        return (new CategoryConroller().deleteCategoryById(id) > 0);
    }
    
    @PUT
    @Path("/updateCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String categoryNames, @HeaderParam("Authorization") String authorizationString)
    {
        if(!authorization.equals(authorizationString))
        {
            return false;
        }
        if (categoryNames.contains(" to ")){
        	String[] advertisementTitle = categoryNames.split(" to ");
        	return (new AdvertisementController().updateAdvertisementByTitle(advertisementTitle[1], advertisementTitle[0]) > 0);
        } else {
        	new CustemException("CategoryResource", "to is not present in given string", "to is not present in given string");
        }
        return false;
    }
}
