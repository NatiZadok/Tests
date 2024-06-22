package UI.object.landingPage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UI.object.BasePage;

public class LandingPage extends BasePage {

	@FindBy(css="[class='sc-dmqHEX sc-eZYOHW hcRTCv fermcI adminjs_Box']")
	private List<WebElement> btnHappyFolderMenu;
	@FindBy(css="[class='sc-dmqHEX sc-eZYOHW hcRTCv fermcI adminjs_Box'] [class='sc-iCmkLe hdeNhd']")
	private List<WebElement> btnToOpenHappyFolderMenu;
	@FindBy(css="[class='sc-ilEZps hilNtv sc-hhGHuG dgJiMC adminjs_Header adminjs_H2']")
	private WebElement txtWelcomeOnBoard;
	
			
	public LandingPage(WebDriver driver) {
		super(driver);				
	}

	public void clickOnHappyFolder()
	{
		for(WebElement txt:btnHappyFolderMenu)
			if(txt.getText().equals("Happy Folder"))
				txt.click();
	}
	
	public void clickOnHappyFolderMenuOption(String optionToSelect)
	{
		for(WebElement txt:btnHappyFolderMenu)
		{
			if(txt.getText().equals(optionToSelect))
				txt.click();
		}
		
	}
	
	public String getWelcomeTxt()
	{
		return txtWelcomeOnBoard.getText();
	}

	
	
}
