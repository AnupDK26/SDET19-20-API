package sdet.ParametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import sdet.GenericUtils.EndPoints;

public class PathParameter {
	
	@Test
	public void pathParameters()
	{
		baseURI = "http://localhost";
		port = 8084;
		
	     given()
	     .pathParam("projID", "TY_PROJ_1405")
	     
	     .when()
	     .get("/projects/{projID}")
	     .then()
	     .log().all();
	     
	}

}
