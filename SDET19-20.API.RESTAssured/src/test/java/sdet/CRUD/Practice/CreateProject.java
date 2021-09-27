package sdet.CRUD.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProjectTest()
	{
		//create a project body using JSON Object
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Deepak");
		 jobj.put("projectName", "TestYantra");
		 jobj.put("status", "Created");
		 jobj.put("teamSize", 60);
		 
		 //send request
		 RequestSpecification req = RestAssured.given();
		 
		 req.contentType(ContentType.JSON);
		 req.body(jobj);
		 
		 Response res = req.post("http://localhost:8084/addProject");
		 
		 //print response
		 System.out.println(res.asString());
		 System.out.println(res.prettyPrint());
		 System.out.println(res.prettyPeek());
		 System.out.println(res.getContentType());
		 System.out.println(res.getStatusCode());
		 System.out.println(res.getTime());
		
	}


}
