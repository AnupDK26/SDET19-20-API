package sdet.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods wrt to database
 * @author Chaitra
 *
 */
public class DataBaseUtility {
	ResultSet result = null;
	Connection conn = null;
	
	public void connectToDB() throws Throwable
	{
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		conn =DriverManager.getConnection(IPathConstants.DBurl, IPathConstants.DBusername, IPathConstants.DBpassword);
		
	}
	
	public void closeDB() throws Throwable
	{
		conn.close();
	}
	
	public String executeQueryandGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		result=conn.createStatement().executeQuery(query);
		while(result.next())
		{
			String data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
				
			}
		}
		
		if(flag)
		{
			System.out.println(expData +"the data is verified");
			return expData;
		}
		else
		{
			System.out.println(expData +"the data is not verified");
			return expData;
		}
		
	}

}
