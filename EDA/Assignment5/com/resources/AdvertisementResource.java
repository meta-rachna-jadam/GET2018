package com.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	public String getAdvertisement() {
		List<Advertisement> advertisementList = new AdvertisementController().getAllAdvertisements();
		Gson gson = new Gson();
		return gson.toJson(advertisementList);
	}

}
