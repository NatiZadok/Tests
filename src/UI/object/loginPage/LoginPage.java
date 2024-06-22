package UI.object.loginPage;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Common.utils.Utils;
import UI.object.BasePage;


public class LoginPage extends BasePage {

	@FindBy(css="[name='email']")
	private WebElement fdEmail;
	@FindBy(css="[name='password']")
	private WebElement fdPassword;
	@FindBy(css="[class='sc-hLseeU dnGqvp adminjs_Button']")
	private WebElement btnLogin;
	@FindBy(css="[class='sc-eDDNvR vjfup adminjs_Label']")
	private List<WebElement> txtEmailPassLabel;


	public LoginPage(WebDriver driver) {
		super(driver);				
	}

    public void enterEmail(String email) {
        fdEmail.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        fdPassword.sendKeys(password);
    }
    
    public void clickLoginButton() {
        btnLogin.click();
    }
    
    public String getLoginButtonText() {
        return btnLogin.getText();
    }
	
    public String getLabelTextEmailPass(String Email)
    {
    	for(WebElement label:txtEmailPassLabel)
    	{
    		if(getText(label).equals(Email))
			{
    			return label.getText();
			}
    	}
		return null;
    }
    
    public List<String> getEmailPassLabelTexts() {
        return txtEmailPassLabel.stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toList());
    }
    
	public void enterDeafultUserNameAndPassword() {
		fdEmail.sendKeys(Utils.readPropStart("user"));
		fdPassword.sendKeys(Utils.readPropStart("password"));
		
		click(btnLogin);
	}
}
