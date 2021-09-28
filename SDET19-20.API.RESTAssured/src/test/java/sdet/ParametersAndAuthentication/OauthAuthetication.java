package sdet.ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OauthAuthetication {
	
	@Test
	public void oathAuthentication()
	{
		Response resp = given()
		.formParam("client_id", "MyAPPTY")
		.formParam("client_secret", "8b2eda707ca73b9eb86d0b55b161bccd")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.asString());
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "1914")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		
		.then().log().all();
		
		
	}

}
