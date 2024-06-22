package UI.object.happyFolder;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import UI.object.BasePage;

public class PostPage extends CommonPage {

	@FindBy(css="[class='sc-gjTGSA cMvPaq adminjs_Text']")
	private WebElement txtNoRecordsLabel;
	@FindBy(css="button[data-testid='action-new']")
	private WebElement btnCreateNew_first;
	@FindBy(css="[class='sc-dmqHEX sc-kGTyPW kTAUKl jhaEvk adminjs_Box'] [data-testid='action-new']")
	private WebElement btnCreateNew;

	/*CreateNew*/
	@FindBy(css="[id='title']")
	private WebElement fdTitle;
	@FindBy(css="[id='content']")
	private WebElement fdContent;
	@FindBy(css="[data-testid='someJson-add']")
	private WebElement btnAddItem;
	@FindBy(css="[class='sc-fsQiph fULarS']")
	private WebElement cbPublished;
	
	/*Add publisher*/
	@FindBy(css="[data-css='Post-edit-publisher'] [class=' css-p6wpjx-control']")
	private WebElement btnOpenPublisherOptions;
	
	/*Status*/
	@FindBy(css="[data-css='Post-edit-status'] [class=' css-k21zfa-ValueContainer']")
	private WebElement btnToSelectStatus;	
	@FindBy(css="[id^='react-select-']")
	private List<WebElement> selectOptionMenuDropDownStatusPublisher;
	
	/*Post table*/
	@FindBy(css="[data-css='Post-table-body'] [data-property-name='title']")
	private List<WebElement> columnPostTitleName;
	@FindBy(css="[data-css='Post-table-body'] [data-property-name='status']")
	private List<WebElement> columnsStatus;
	
	@FindBy(css="[class='sc-kgKVFY fbgjLs options'] [data-testid='actions-dropdown']")
	private List<WebElement> openActionDropDownMenu;
	
	@FindBy(css="[data-css='Post-edit-button']")
	private WebElement btnEdit;	
	

	public PostPage(WebDriver driver) {
		super(driver);				
	}

	public void clickOpenPublisherOptions()
	{
		btnOpenPublisherOptions.click();
	}
	
	public void clickbtnToSelectStatus()
	{
		btnToSelectStatus.click();
	}
	
	public void enterTitle(String title) {
		fdTitle.clear();
		fdTitle.sendKeys(title);
	}

	public void enterContent(String content) {
		fdContent.clear();
		fdContent.sendKeys(content);
	}

	public void clickbtnAddItem(String title) {
		btnAddItem.click();
	}
	
	public void selectStatusOrPublisher(String optionToSelect)
	{
		for(WebElement txt:selectOptionMenuDropDownStatusPublisher)
		{
			if(txt.getText().equals(optionToSelect))
			{
				Actions action = new Actions(driver);
				action.moveToElement(txt).click().perform();
				break;
			}
		}
	}
	
	public void clickCbPublished()
	{
		cbPublished.click();
	}
	
	public void clickActionDropDown(String titleName)
	{
		for(int i=0;i<columnPostTitleName.size();i++)
		{
			if(columnPostTitleName.get(i).getText().equals(titleName))
				 columnsStatus.get(i).click();
		}
	}
	
	public String statusForTitleName(String titleName)
	{
		for(int i=0;i<columnPostTitleName.size();i++)
		{
			if(columnPostTitleName.get(i).getText().equals(titleName))
				return openActionDropDownMenu.get(i).getText();
		}
		return null;
	}

	public void selectPostFromTableByTitleName(String optionToSelect)
	{
		for(WebElement titleName:columnPostTitleName)
		{
			if(titleName.getText().equals(optionToSelect))
			{
				titleName.click();
				break;
			}
		}
	}
	
	public void clickEdit()
	{
		btnEdit.click();
	}
	
	public String getNoRecordsLabel()
	{
		return txtNoRecordsLabel.getText();
	}
	
}
