package API.functions;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matcher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import API.tests.BaseTestAPI;
import Common.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIFunctions extends BaseTestAPI{
	
	public APIFunctions() 
	{}

	
	public static Response Put(String url, String body) 
	{
		System.out.println("put "+url+" "+body);
		
		Response response = RestAssured.given()
		         .header("Content-Type", "application/json")
		         .body(body)
		         .when()
		         .put(url)
		         .then()
		         .extract().response();
		 return response;
	}
	
	public static Response Delete(String URL)
	{	
		System.out.println("DELETE "+URL);

		Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .delete(URL)
                .then()
                .extract().response();
			return response;
	}
	
	
	public static Response GetQuery(String APIRequestName,int delay, int currentPage, int perPage) 
	{
		System.out.println("GET "+APIRequestName);
	 
	    Response response = RestAssured.given()
	            .queryParam("delay", delay)
	            .queryParam("page", currentPage)
	            .queryParam("per_page", perPage)
	            .when()
	            .get("/users")
	            .then()
	            .assertThat()
	            .statusCode(200)
//	            .time(lessThan(10L, TimeUnit.SECONDS)) // Ensure response arrives within 10 seconds
	            .extract()
	            .response();
	    return response;
	}

	public static Response Post(String requestBody) 
	{	
		Response response = RestAssured.given()
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .when()
	                .post("/register")
	                .then()
	                .extract().response();
		 return response;
	}
	
	public static <T> String convertObjectToJson(T object) throws JsonProcessingException {
	    ObjectMapper mapper = new ObjectMapper();
	    
	    try {
	        // convert object to json string and return it
	        return mapper.writeValueAsString(object);
	    } catch (JsonProcessingException e) {
	        // catch errors
	        e.printStackTrace();
	        throw e; // rethrow the exception
	    }
	}

	public static  int getTotalUser(Response response)
	{
		 return response.jsonPath().getInt("total");
	}
	
	public static  int getTotalPages(Response response)
	{
		 return response.jsonPath().getInt("total_pages");
	}
	
	public static  List<String> getUsersOnPage(Response response)
	{
		 return response.jsonPath().getList("data.email");
	}
	
	public static String getErrorMessage(Response response)
	{
		 return response.jsonPath().getString("error");
	}
	
	public static Response RegisterUser(String email,String password) throws JsonProcessingException
	{
		User newUser = new User(email,password);
		newUser.printUser();
		Response response =	Post(convertObjectToJson(newUser));
		return response;
	}
	
	public static String getId(Response response)
	{
		 return response.jsonPath().getString("id");
	}
	
	public static String getToken(Response response)
	{
		 return response.jsonPath().getString("token");
	}
	
}
