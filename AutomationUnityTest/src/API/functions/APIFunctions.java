package API.functions;
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
		         .cookie(adminjsCookie)
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
				.cookie(adminjsCookie)
                .header("Content-Type", "application/json")
                .when()
                .post(URL)
                .then()
                .extract().response();
			return response;
	}
	
	
	public static Response Get(String APIRequestName) 
	{
		System.out.println("GET "+APIRequestName);
	 
			Response response = RestAssured.given()
				 .cookie(adminjsCookie)
		         .header("Content-Type", "application/json")
		         .when()
		         .get(APIRequestName)
		         .then()
		         .extract().response();
			 return response;
	}
	
	public static Response Post(String APIRequestURL, String requestBody) 
	{
		System.out.println("POST "+APIRequestURL+" "+requestBody);
		
		Response response = RestAssured.given()
					.cookie(adminjsCookie)
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .when()
	                .post(APIRequestURL)
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


	public static Response CreatePublisher(String Name,String Email) throws JsonProcessingException
	{
		Publisher NewPublisher = new Publisher(Name,Email);
		NewPublisher.printPublisher();
		Response response =	Post(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("createPublisher")),convertObjectToJson(NewPublisher));
		return response;
	}
	
	public static Response deletePublisher(String id) throws JsonProcessingException
	{
		Response response =	Delete(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("deletePublisher")+id+"/delete"));
		return response;
	}
	
	public static Response deletePost(String id) throws JsonProcessingException
	{
		Response response =	Delete(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("deletePost")+id+"/delete"));
		return response;
	}
	
	public static Response editPost(String title, String content, String status, boolean published, String publisher,String id) throws JsonProcessingException
	{
		Post editPost = new Post(title,content,status,published,publisher);
		editPost.printPost();
		Response response =	Post(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("editPost")+id+"/edit"),convertObjectToJson(editPost));
		return response;
	}
	
	public static Response CreatePost(String title, String content, String status, boolean published, String publisher) throws JsonProcessingException
	{
		Post NewPost = new Post(title,content,status,published,publisher);
		NewPost.printPost();
		Response response =	Post(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("createPost")),convertObjectToJson(NewPost));
		return response;
	}

	public static String getIdForGivenNamePublisherList(String publisherName)
	{
		Response res = Get(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("listPublisher")));
		System.out.println(res.asString());
		String id = res.path("records.find { it.params.name == \"" + publisherName + "\" }.params.id").toString();
		System.out.println("id= "+id);
		return id;
	}
	
	public static String getIdForGivenTitlePostList(String title)
	{
		Response res = Get(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("listPost")));
		System.out.println(res.asString());
		String id = res.path("records.find { it.params.title == \"" + title + "\" }.params.id").toString();
		System.out.println("id= "+id);
		return id;
	}
	
	public static String getStatusForGivenTitlePostList(String title)
	{
		Response res = Get(Utils.BuildServerUrlAPI(Utils.readPropStartAPI("listPost")));
		System.out.println(res.asString());
		String status = res.path("records.find { it.params.title == \"" + title + "\" }.params.status").toString();
		System.out.println("status= "+status);
		return status;
	}
	
}
