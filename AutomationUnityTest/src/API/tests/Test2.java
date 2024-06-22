package API.tests;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

import API.functions.APIFunctions;

public class Test2 extends BaseTestAPI  {

		@Test(description = "Test2 - API")
		public void T01_Test2API() throws JsonProcessingException  
		{
			//1. Create Publisher
			Response responseCreatePublisher =APIFunctions.CreatePublisher("PublisherTestAPI", "Publisher1@123");
			Assert.assertEquals(responseCreatePublisher.getStatusCode(),HttpStatus.SC_OK);
			String idPublisher=APIFunctions.getIdForGivenNamePublisherList("PublisherTestAPI");
			
			//2. Create Post - link to the Publisher created( Status > Active Published=True)
			Response responseCreatePost =APIFunctions.CreatePost("PostTestAPI"," ", "ACTIVE", true,idPublisher);
			Assert.assertEquals(responseCreatePost.getStatusCode(),HttpStatus.SC_OK);
			String idPost=APIFunctions.getIdForGivenTitlePostList("PostTestAPI");
			
			//3. Edit Post> Change status to remove and save
			Response EditPost =APIFunctions.editPost("PostTestAPI"," ", "REMOVED", true,idPublisher,idPost);	
			Assert.assertEquals(responseCreatePost.getStatusCode(),HttpStatus.SC_OK);
			
			//4. Validate post status was changed to Remove from the Post page
			Assert.assertEquals(APIFunctions.getStatusForGivenTitlePostList("PostTestAPI"),"REMOVED");
			
			//Extra - Delete post
			Response deletePost =APIFunctions.deletePost(idPost);	
			Assert.assertEquals(deletePost.getStatusCode(),HttpStatus.SC_OK);
		}
}
