package API.tests;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import API.functions.APIFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Register extends BaseTestAPI  {

	
	@Test(description = "successfulRegister")
	public void T01_successfulRegister() throws JsonProcessingException  
	{
		Response successfulReg =APIFunctions.RegisterUser("eve.holt@reqres.in", "pistol");
		Assert.assertEquals(successfulReg.getStatusCode(),HttpStatus.SC_OK);
		
		Assert.assertEquals(APIFunctions.getId(successfulReg),"4");
		Assert.assertEquals(APIFunctions.getToken(successfulReg),"QpwL5tke4Pnpja7X4");
	}
	
	@Test(description = "unsuccessfulRegister")
	public void T02_unsuccessfulRegister() throws JsonProcessingException  
	{
		Response successfulReg =APIFunctions.RegisterUser("eve.holt@reqres.in", "");
		Assert.assertEquals(successfulReg.getStatusCode(),HttpStatus.SC_BAD_REQUEST);
		
		Assert.assertEquals(APIFunctions.getErrorMessage(successfulReg),"Missing password");
	}

}
