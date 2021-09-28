package sdet.GenericUtils;

import io.restassured.response.Response;

/**
 * This class contins methods related to rest assured
 * @author Chaitra
 *
 */
public class RestAssuredUtilities {
	
    /**
     * This method will return json data after extracting from the json path
     * @param resp
     * @param jsonpath
     * @return
     */
	public String getJsonData(Response resp,String jsonpath )
	{
		String jsonData = resp.jsonPath().get(jsonpath);
		return jsonData;
	}

}
