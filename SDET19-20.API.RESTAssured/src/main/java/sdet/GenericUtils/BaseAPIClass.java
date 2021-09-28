package sdet.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public RestAssuredUtilities rLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI = "http://localhost";
		port = 8084;
		
		dLib.connectToDB();
		System.out.println("========DB Connection successfull=======");
	}
	
	@AfterSuite
	public void asCconfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("=========DB Close successful======");
	}

}
