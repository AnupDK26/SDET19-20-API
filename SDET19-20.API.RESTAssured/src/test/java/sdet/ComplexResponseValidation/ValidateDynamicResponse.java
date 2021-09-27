package sdet.ComplexResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import sdet.GenericUtils.EndPoints;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponse {
	
	@Test
	public void validateDynamicResp()
	{
		//get the exp data
		String expData = "Emc";
		
		baseURI = "http://localhost";
		port = 8084;
		
		//get all the projects
		Response resp = when()
		.get(EndPoints.getAllProjects);
		
		//write a json path to get all the project names
		List<String> pName = resp.jsonPath().get("projectName");
		
		for(String actData :pName)
		{
			System.out.println(actData);
			if(actData.equals(expData))
			{
				System.out.println(actData + "the data is verified");
				break;
			}
		}
		
		resp.then().log().all();
		
	}

}
