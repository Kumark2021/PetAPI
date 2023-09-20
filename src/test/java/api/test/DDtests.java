package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	
	public void postUser(String userID,String userName,String fname,String lname,String email,String pwd,String ph)
	
	{
		User userPayload= new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response =UserEndPoints.createUser(userPayload);
		//response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="usernames",dataProviderClass=DataProviders.class)
	
	public void testDeleteUserbyName(String userName)
	{
		
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	

}
