package com.revature.charity.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Admin;
import com.revature.charity.service.AdminService;
import com.revature.charity.service.AdminServiceImpl;

public class AdminLoginController {
	public static String adminLogin(Admin admin)
	{
		String errorMsg = null;
		AdminService service = new AdminServiceImpl();
		Admin adminObj = null;
		try {
			adminObj = service.adminLoginService(admin);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		//prepare JSON obj
		String json = null;
		Gson gson = new Gson();
		if(adminObj != null)
		{
			json = gson.toJson(adminObj);
		} else if(adminObj == null){
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		return json;	
	}
}
