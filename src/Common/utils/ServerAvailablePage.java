package Common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.SkipException;

import UI.object.BasePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServerAvailablePage extends BasePage {

	@FindBy(css="[id='main-message']")
	private WebElement txtThisSiteCantBeReached;
	public ServerAvailablePage(WebDriver driver) {
		super(driver);				
	}
	public String getMessageThisSiteCantBeReached() {
		return getText(txtThisSiteCantBeReached);
	}	

	public boolean getLoginPageStatus() 
	{
		//RestAssured.baseURI = Utils.readPropStart("url");

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.

		int statusCode = response.getStatusCode();

		if(statusCode ==200)
		{ 
			return true;
		}
		else
		{   
			throw new SkipException("Skipping this exception");
		}
	}
}
