package sdet.CRUD.Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	public void getAllProjects()
	{
		Response res = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.getStatusCode());
	}

}
