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

import com.controller.CategoryConroller;
import com.google.gson.Gson;
import com.model.Category;

@Path("category")
public class CategoryResource {

	@GET
	@Path("getCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdvertisement(@HeaderParam("Authorization") String authorizationString) {
		if (!"GET-2018".equals(authorizationString)) {
			return "401 Unauthorized";
		}
		List<Category> categoryList = new CategoryConroller().getAllCategories();
		Gson gson = new Gson();
		return gson.toJson(categoryList);
	}	
	
	@POST
    @Path("/addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addCategory(String categoryInput, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        Gson g = new Gson();
        Category category = g.fromJson(categoryInput, Category.class);
        boolean result = (new CategoryConroller().addCategory(category) > 0);
        return result;
    }
    
    @DELETE
    @Path("/deleteCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteCategory(String categoryID, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        int id = Integer.parseInt(categoryID);
        boolean result = (new CategoryConroller().deleteCategoryById(id) > 0);
        return result;
    }
    
    @PUT
    @Path("/updateCategory")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateCategory(String categoryNames, @HeaderParam("Authorization") String authorizationString)
    {
        if(!"GET-2018".equals(authorizationString))
        {
            return false;
        }
        String[] categoryName = categoryNames.split(" to ");
        boolean result = (new CategoryConroller().updateCategoryName(categoryName[1], categoryName[0]) > 0);
        return result;
    }
}
