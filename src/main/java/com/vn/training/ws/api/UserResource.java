package com.vn.training.ws.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vn.training.persistence.entity.UserEntity;

@Path("user")
public class UserResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/get")
	public String getUser() {
		return "Got it!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getjson")
	public UserEntity getUserJson() {
		UserEntity user = new UserEntity();
		user.setId(100);
		user.setName("name");
		return user;
	}
}
