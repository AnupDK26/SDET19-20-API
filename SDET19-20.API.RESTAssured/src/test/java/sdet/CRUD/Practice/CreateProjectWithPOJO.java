package sdet.CRUD.Practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet.GenericUtils.EndPoints;
import sdet.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectWithPOJO {
	
	@Test
	public void createProjectWithPOJO()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//get the data using pojo
		ProjectLibrary pLib= new ProjectLibrary("Shah Rukh Khan","DDLJ","Completed",85);
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post(EndPoints.addProject)
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
