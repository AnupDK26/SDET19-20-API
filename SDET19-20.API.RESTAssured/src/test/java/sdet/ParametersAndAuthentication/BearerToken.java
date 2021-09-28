package sdet.ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {
	
	@Test
	public void bearerToken()
	{
		HashMap map = new HashMap();
		map.put("name", "MySdetRepo");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then()
		.log().all();
	}

}
