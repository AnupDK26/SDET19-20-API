package sdet.CRUD.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import sdet.GenericUtils.EndPoints;
import sdet.GenericUtils.IPathConstants;

public class CreateProjectWithJsonfile {
	
	@Test
	public void createProjectWithJsonfile() throws Throwable
	{
		baseURI = "http://localhost";
		port = 8084;
		
		FileInputStream file = new FileInputStream(IPathConstants.JsonFilePath);
		/*String var ="{  \"createdBy\": \"Chetan\","
				+ "  \"projectName\": \"Xylem\","
				+ "  \"status\": \"completed\","
				+ "  \"teamSize\": 75}";*/
				
		given()
		.contentType(ContentType.JSON)
		.body(file)
		
		.when()
		.post(EndPoints.addProject)
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
