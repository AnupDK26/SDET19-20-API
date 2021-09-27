package sdet.CRUD.Practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingBDD {
	
	@Test
	public void createProjectUsingBDD()
	{
		//create request body
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Deepak");
		 jobj.put("projectName", "TestYantra");
		 jobj.put("status", "Created");
		 jobj.put("teamSize", 60);
		 
		 given()
		  .contentType(ContentType.JSON)
		  .body(jobj)
		 
		 .when()
		  .post("http://localhost:8084/addProject")
		 
		 .then()
		  .assertThat().statusCode(201).log().all();
		
	}

}
