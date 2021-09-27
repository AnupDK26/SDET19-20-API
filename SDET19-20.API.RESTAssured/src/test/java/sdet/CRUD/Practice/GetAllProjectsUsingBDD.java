package sdet.CRUD.Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsUsingBDD {
	
	@Test
	public void getAllProjectUsingBDD() 
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("/projects")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
}

}
