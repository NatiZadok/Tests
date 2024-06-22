package API.tests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matcher;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

import API.functions.APIFunctions;

public class ValidateUsersExist extends BaseTestAPI  {

	@Parameters({"delay","perPage", "page"})
	@Test
	public void testValidateUsersExist(
			@Optional("10") int delay,
			@Optional("6") int perPage,
			@Optional("2") int page) {
		List<String> allUsers = new ArrayList<>();

		Response userExist = APIFunctions.GetQuery("/users", 10, perPage, perPage);

		/*Extract users from the first page*/
		List<String> usersOnPage = APIFunctions.getUsersOnPage(userExist);

		System.out.println("users On Page "+usersOnPage);

		/*Verify all expected users by email exist*/
		Assert.assertTrue(allUsers.contains("michael.lawson@reqres.in"));
		Assert.assertTrue(allUsers.contains("lindsay.ferguson@reqres.in"));
		Assert.assertTrue(allUsers.contains("tobias.funke@reqres.in"));
		Assert.assertTrue(allUsers.contains("byron.fields@reqres.in"));
	}
}
