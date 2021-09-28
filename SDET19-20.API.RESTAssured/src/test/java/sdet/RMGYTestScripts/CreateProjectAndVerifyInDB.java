package sdet.RMGYTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import sdet.GenericUtils.BaseAPIClass;
import sdet.GenericUtils.EndPoints;
import sdet.POJOClass.ProjectLibrary;

public class CreateProjectAndVerifyInDB extends BaseAPIClass{
	
	@Test
	public void createProjectAndVerifyDB() throws Throwable
	{
		//create post request
		ProjectLibrary pLib = new ProjectLibrary("Chaitra", "Qualitest"+jLib.getRandomNumber(), "Completed", 25);
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(EndPoints.addProject);
		
		//extract project id
		String expData = rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//validate the exp data in daabase
		String query = "select * from project;";
		String actData = dLib.executeQueryandGetData(query, 1, expData);
		System.out.println(actData);
		
		Assert.assertEquals(actData, expData);
		System.out.println("data verified successfully");
		
		
		
	}
	
    
	
}
