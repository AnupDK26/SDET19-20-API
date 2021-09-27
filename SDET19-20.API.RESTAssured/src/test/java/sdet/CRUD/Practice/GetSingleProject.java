package sdet.CRUD.Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test
	public void getSingleProject()
	{
		Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_802");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.getStatusCode());
	}

}
