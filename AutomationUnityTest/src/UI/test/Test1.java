
package UI.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.utils.Utils;
import UI.object.happyFolder.PostPage;
import UI.object.happyFolder.PublisherPage;
import UI.object.landingPage.LandingPage;
import UI.object.loginPage.LoginPage;
import io.qameta.allure.Description;

public class Test1 extends BaseTest{

	@Test(description ="Test1")
	@Description()
	public void T01_()
	{
		//Navigate to login page , insert user and password
		LoginPage login = new LoginPage(driver);
		login.enterDeafultUserNameAndPassword();

		//Make sure you are indeed on the landing page 
		LandingPage landing = new LandingPage(driver);
		Assert.assertEquals(landing.getWelcomeTxt(), "Welcome on Board!");

		//Navigate to Publisher page
		landing.clickOnHappyFolder();
		landing.clickOnHappyFolderMenuOption("Publisher");

		//1. Create Publisher
		PublisherPage publisher = new PublisherPage(driver);
		publisher.clickCreateNew();
		publisher.enterName("PublisherUI");
		publisher.enterEmail("PublisherUI@123");
		publisher.clickSave();

		//2. Create Post - link to the Publisher created( Status > Active Published=True)
		PostPage post = new PostPage(driver);
		landing.clickOnHappyFolderMenuOption("Post");
		post.clickCreateNew();
		post.enterTitle("postTestUI");
		post.clickbtnToSelectStatus();
		post.selectStatusOrPublisher("ACTIVE");
		post.clickCbPublished();
		post.clickOpenPublisherOptions();
		post.selectStatusOrPublisher("PublisherUI@123");
		post.clickSave();

		//4. Validate post status was changed to Remove from the Post page
		/*Have an issue to update status*/
		//		post.selectPostFromTableByTitleName("postTest");
		//		post.clickEdit();
		//		post.clickbtnToSelectStatus();
		//		post.selectStatusOrPublisher("REMOVED");
		//		post.clickSave(); 
		//		
		//		Assert.assertEquals(post.statusForTitleName("postTest") ,"REMOVED");
		
		post.clickActionDropDown("postTestUI");
		post.clickactionDelete();
		post.clickconfirmDelete();
		Assert.assertEquals(post.getNoRecordsLabel() ,"There are no records in this resource");

	}
}
