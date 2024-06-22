package UI.object.happyFolder;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UI.object.BasePage;

public class PublisherPage extends CommonPage {

	@FindBy(css="[class='sc-gjTGSA cMvPaq adminjs_Text']")
	private WebElement txtNoRecordsLabel;
	@FindBy(css="button[data-testid='action-new']")
	private WebElement btnCreateNew;
	
	
	//CreateNew
	@FindBy(css="[id='name']")
	private WebElement fdName;
	@FindBy(css="[id='email']")
	private WebElement fdEmail;
	
	@FindBy(css="[type='submit']")
	private WebElement btnSave;


	public PublisherPage(WebDriver driver) {
		super(driver);				
	}

	
	public void enterName(String title) {
		fdName.clear();
		fdName.sendKeys(title);
	}

	public void enterEmail(String content) {
		fdEmail.clear();
		fdEmail.sendKeys(content);
	}


}
