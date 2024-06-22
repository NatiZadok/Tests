package UI.object.happyFolder;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UI.object.BasePage;

public class CommonPage extends BasePage {

	@FindBy(css="[class='sc-gjTGSA cMvPaq adminjs_Text']")
	private WebElement txtNoRecordsLabel;
	@FindBy(css="[class='sc-ilEZps eOGlIj sc-hhGHuG dgJiMC adminjs_Header adminjs_H2']")
	private WebElement txtListLabel;
	
	@FindBy(css="button[data-testid='action-new']")
	private WebElement btnCreateNew_first;
	@FindBy(css="[class='sc-dmqHEX sc-kGTyPW kTAUKl jhaEvk adminjs_Box'] [data-testid='action-new']")
	private WebElement btnCreateNew;
	
	@FindBy(css="[type='submit']")
	private WebElement btnSave;
	
	/*Action Menu options*/
	@FindBy(css="[data-testid='action-delete']")
	private WebElement actionDelete;
	@FindBy(css="[data-testid='action-edit']")
	private WebElement actionEdit;
	@FindBy(css="[data-testid='action-show']")
	private WebElement actionShow;
	@FindBy(css="[label='Confirm']")
	private WebElement confirmDelete;

	
	public CommonPage(WebDriver driver) {
		super(driver);				
	}
	
	public void clickconfirmDelete()
	{
		confirmDelete.click();
	}

	public void clickactionDelete()
	{
		actionDelete.click();
	}
	
	public void clickactionEdit()
	{
		actionEdit.click();
	}
	
	public void clickSave()
	{
		btnSave.click();
	}
	
	public void clickactionShow()
	{
		actionShow.click();
	}
	
	public void clickCreateNew()
	{
		try 
		{	
			btnCreateNew_first.click();
			
		} catch (NoSuchElementException e) 
		{
			btnCreateNew.click();
			System.out.println("Exceptio : "+ e.toString());
		}
	}

}
