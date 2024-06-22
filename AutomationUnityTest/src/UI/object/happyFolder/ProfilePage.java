package UI.object.happyFolder;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends CommonPage {

	@FindBy(css="[class='sc-gjTGSA cMvPaq adminjs_Text']")
	private WebElement txtNoRecordsLabel;
	@FindBy(css="button[data-testid='action-new']")
	private WebElement btnCreateNew;

	//CreateNew
	@FindBy(css="[id='bio']")
	private WebElement fdBio;
	@FindBy(css="[class=' css-uayuwa-Input']")
	private WebElement btnToSelect;	
	
	@FindBy(css="[id^='react-select-8-option-']")
	private List<WebElement> selectOptionMenuDropDown;
	@FindBy(css="[type='submit']")
	private WebElement btnSave;


	public ProfilePage(WebDriver driver) {
		super(driver);				
	}
	
	public void setBio(String title) {
		fdBio.clear();
		fdBio.sendKeys(title);
	}

	public void clickSave()
	{
		btnSave.click();
	}

}
