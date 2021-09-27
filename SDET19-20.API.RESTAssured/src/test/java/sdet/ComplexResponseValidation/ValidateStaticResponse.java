package sdet.ComplexResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import sdet.GenericUtils.EndPoints;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponse {
	
	@Test
	public void validateStaticResp()
	{
		baseURI = "http://localhost";
		port = 8084;
		//expected data
		String expData ="TY_PROJ_1204";
		
		//get all the projects
		Response resp = when()
		.get(EndPoints.getAllProjects);
		
		//fetch the 0th index projectid
		String actData = resp.jsonPath().get("[1].projectId");
		System.out.println(actData);
		
		//validate
		Assert.assertEquals(actData, expData);
	}

}
