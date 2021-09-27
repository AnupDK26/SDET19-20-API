package sdet.CRUD.Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectUsingBDD {
	@Test
	public void deleteProjectUsingBDD()
	{
		baseURI = "http://localhost";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_2002")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
