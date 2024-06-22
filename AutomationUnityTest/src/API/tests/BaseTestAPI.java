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

//	@BeforeClass
//	public void Setup() throws JsonProcessingException 
//	{
//		RestAssured.useRelaxedHTTPSValidation(); //ignore certification errors
//		Utils.initPropsFile();
//		
//        // Create a Map to hold the request body parameters
//        Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("email", Utils.readPropStartAPI(""));
//        requestBody.put("password",  Utils.readPropStartAPI(""));
//        
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonBody = objectMapper.writeValueAsString(requestBody);
//        
//		Response loginResponse = RestAssured.given()
//				.contentType("application/json")
//				.body(jsonBody) 
//				.when()
//				.post("http://localhost:3000/admin/login") 
//				.then()
//				.statusCode(302)
//				.extract()
//				.response();
//		
//		// Extract the `adminjs` cookie
//		adminjsCookie = loginResponse.getDetailedCookie("adminjs");
//
//		if (adminjsCookie == null) {
//			throw new IllegalStateException("adminjs cookie not found.");
//		}
//	      System.out.println("Extracted adminjs cookie: " + adminjsCookie.getValue());		
//	}
}
