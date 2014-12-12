package com.vn.training.ws.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.vn.training.persistence.entity.UserEntity;

@Provider
@Path("user")
public class UserProvider {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json/get/{id}")
	public UserEntity getUserJson(@PathParam("id") int userId) {
		UserEntity user = new UserEntity();
		user.setId(userId);
		user.setName("name" + userId);
		return user;
	}
}
