package sdet.CRUD.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet.GenericUtils.EndPoints;
import sdet.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectWithMultipleData {
	
	@Test(dataProvider = "getData")
	public void createProjectWithMultipleData(String createdBy, String projectName, String status, int teamSize)
	{
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary plib=new ProjectLibrary(createdBy, projectName, status,teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post(EndPoints.addProject)
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[5][4];
		
		data[0][0]="Shwetha";
		data[0][1]="Photon";
		data[0][2]="Completed";
		data[0][3]=25;
		
		data[1][0]="Shwetha";
		data[1][1]="Photon";
		data[1][2]="Completed";
		data[1][3]=25;
		
		data[2][0]="Shwetha";
		data[2][1]="Photon";
		data[2][2]="Completed";
		data[2][3]=25;
		
		data[3][0]="Shwetha";
		data[3][1]="Photon";
		data[3][2]="Completed";
		data[3][3]=25;
		
		data[4][0]="Shwetha";
		data[4][1]="Photon";
		data[4][2]="Completed";
		data[4][3]=25;
		
		return data;
		
	}

}
