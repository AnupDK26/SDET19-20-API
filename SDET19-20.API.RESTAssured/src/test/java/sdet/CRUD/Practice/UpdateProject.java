package sdet.CRUD.Practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject()
	{
		//create project body
		HashMap map = new HashMap();
		map.put("createdBy", "Deepak");
		map.put("projectName", "TestYantra");
		map.put("status", "Completed");
		map.put("teamSize", 60);
		
		//send the request
		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		req.body(map);
		
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_2004");
		
		System.out.println(res.prettyPeek());
		System.out.println(res.getStatusCode());
	}

}
