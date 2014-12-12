package com.vn.training.ws.api;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.vn.training.persistence.entity.UserEntity;

public class UserResourceTest extends TestCase {
    
	private HttpServer server;
	private Client client;
	
	public static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(9998).build();

	protected static HttpServer startServer() throws IOException {
        ResourceConfig rc = new PackagesResourceConfig("com.vn.training.ws.api");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }
	
	protected void setUp() throws Exception {
		super.setUp();
		server = startServer();
		client = Client.create();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		server.stop();
		client.destroy();
	}

	public void testGetUserJson() {
		WebResource webResource = client.resource(BASE_URI).path("/user/json/get/200");
		UserEntity user = webResource.accept(MediaType.APPLICATION_JSON).get(UserEntity.class);
		Assert.assertEquals(200, user.getId());
	}

}
