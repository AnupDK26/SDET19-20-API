package sdet.ParametersAndAuthentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import sdet.GenericUtils.EndPoints;
import sdet.POJOClass.ProjectLibrary;

public class RequestChaining {
	
	@Test
	public void requestChaining()
	{
		baseURI = "http://localhost";
		port = 8084;
			
		// create a project
		ProjectLibrary pLib = new ProjectLibrary("Namratha","SDET","Created",56);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.and()
		.body(pLib)
		.when()
		.post(EndPoints.addProject);
		
		//capture the response
		String myProjId = resp.jsonPath().get("projectId");
		System.out.println(myProjId);
		
		//perform get operation on the captured id
		given()
		.pathParam("pid",myProjId)
		
		.when()
		.delete("/projects/{pid}")
		
		.then()
		.assertThat().statusCode(204).log().all();
		
		
	}

}
