package API.tests;

import org.testng.annotations.BeforeClass;
import Common.utils.Utils;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BaseTestAPI {

	protected static Cookie adminjsCookie;

	@BeforeClass
	public void Setup() throws JsonProcessingException 
	{
		RestAssured.useRelaxedHTTPSValidation(); //ignore certification errors
		Utils.initPropsFile();
		
		RestAssured.baseURI = "https://reqres.in/api";
	}
}
