package com.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
}
