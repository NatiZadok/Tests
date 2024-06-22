package UI.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Common.utils.Utils;


public class BaseTest {

	protected WebDriver driver;

	@Parameters ({ "browser" })
	@BeforeClass
	   public void Setup(ITestContext testContext , @Optional("Chrome") String browser) {
		  Utils.initPropsFile();
	      driver = Utils.getDriver(browser);
	      testContext.setAttribute("WebDriver", this.driver);
	      driver.get(Utils.BuildServerUrl(Utils.readPropStart("LoginPage")));
	      driver.manage().window().maximize();
	   }

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
