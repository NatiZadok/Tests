package API.tests;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import API.functions.APIFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PaginationBehavior extends BaseTestAPI  {


    @Parameters({"delay","perPage", "startPage"})
    @Test public void testPaginationBehavior(
    		@Optional("10") int delay,
            @Optional("6") int perPage,
            @Optional("2") int page) {
    	
    	int startPage=1;
        List<String> allUsers = new ArrayList<>();

        /*First request to determine total users and total pages*/
        
        Response firstResponse = APIFunctions.GetQuery("/users", 10, startPage, perPage);

        int totalUsers = APIFunctions.getTotalUser(firstResponse);
        int totalPages = APIFunctions.getTotalPages(firstResponse);

        System.out.println("Total users: "+totalUsers+" Total pages: "+totalPages);
        
        /*Extract users from the first page*/
        List<String> usersOnPage = APIFunctions.getUsersOnPage(firstResponse);
        
        System.out.println("User on page "+usersOnPage);
        
        allUsers.addAll(usersOnPage);
        System.out.println("All users: "+allUsers);

        /*Verify the number of users on the first page*/
        if (totalUsers > perPage) {
            Assert.assertEquals(usersOnPage.size(), perPage);
        } else {
            Assert.assertEquals(usersOnPage.size(), totalUsers);
        }

        /*check all other pages*/
        for (int currentPage = startPage + 1; currentPage <= totalPages; currentPage++) 
        {
            Response response = APIFunctions.GetQuery("/users", 10, currentPage, perPage);
            
            /*Extract users from the current page and add to the list*/
            usersOnPage = APIFunctions.getUsersOnPage(response);
            allUsers.addAll(usersOnPage);

            /*Verify the number of users on the current page*/
            if (currentPage < totalPages) {
                Assert.assertEquals(usersOnPage.size(), perPage);
            } else {
                int expectedLastPageUsers = totalUsers % perPage;
                if (expectedLastPageUsers == 0) {
                    expectedLastPageUsers = perPage;
                }
                Assert.assertEquals(usersOnPage.size(), expectedLastPageUsers);
            }
        }

        System.out.println("All users: "+allUsers);
        
        /*Verify the total number of users retrieved*/
        Assert.assertEquals(allUsers.size(), totalUsers);

        /*Verify all expected users by email exist*/
        Assert.assertTrue(allUsers.contains("michael.lawson@reqres.in"));
        Assert.assertTrue(allUsers.contains("lindsay.ferguson@reqres.in"));
        Assert.assertTrue(allUsers.contains("tobias.funke@reqres.in"));
        Assert.assertTrue(allUsers.contains("byron.fields@reqres.in"));
        Assert.assertTrue(allUsers.contains("george.edwards@reqres.in"));
        Assert.assertTrue(allUsers.contains("rachel.howell@reqres.in"));
    }

}
