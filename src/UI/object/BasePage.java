
package UI.object;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;
	private static String mainWindow;
	
	@FindBy(css="[name='footer']")
	public WebElement footer;
	@FindBy(css="#content")
	public WebElement permisMsg;

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	protected void highlightElement(WebElement element, String color) {
			//keep the old style to change it back
			String originalStyle = element.getAttribute("style");
			String newStyle = "border: 2px solid " + color + ";" + originalStyle;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// Change the style 
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
					element);

			// Change the style back after few miliseconds
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
					+ originalStyle + "');},400);", element);

		}
         //This is ScrollDown JavaScript Method
		public void ScrollDown(WebElement value)
		{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", value); 
		}	
	
		
        //This is ScrollDown JavaScript Method
		public void Scroll_NavigateToBottom()
		{
			JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
			jsExecuter.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		public boolean isPermissionsDenied() {
			if(getText(permisMsg).contains("You do not have the appropriate permissions to view this page.")) {
				return true;
			}
			return false;
		} 	

	public void click(WebElement el) {
		highlightElement(el, "orange");
		el.click();
		//sleep(4000);
		sleep(3500);
	}

	public void fillText(WebElement el,String text) {
		highlightElement(el, "orange");
		el.clear();
		el.sendKeys(text);
		sleep(2500);
		
	}
	
	public void fillEmptyText(WebElement el) {
		highlightElement(el, "orange");
		el.clear();
		sleep(300);
	}

	public String getText(WebElement el) {
		highlightElement(el, "green");
		return el.getText();
	}

	protected void submit(WebElement el) {
		highlightElement(el, "orange");
		el.submit();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void maxWindow() {
		driver.manage().window().maximize();
	}

	public void sleep(long milsec) {
		try {
			Thread.sleep(milsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public void switchToFrame(WebElement FrameName) {
		driver.switchTo().frame(FrameName);
		//sleep(2000);
		sleep(1500);
	}	

	public void goToFooter(){
		driver.switchTo().defaultContent();
		//sleep(2000);
		sleep(1500);
		driver.switchTo().frame(footer);
		//sleep(2000);
		sleep(1500);
	}

	public void afterSwitchFrame() {
		driver.switchTo().defaultContent();
		//sleep(2000);
		sleep(1500);
	}

	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		String lastWindow = "";
		for (String currentWindow : allWindows) {
			lastWindow = currentWindow;
		}
		driver.switchTo().window(lastWindow);
		sleep(2000);
	}
 
	protected void closeWindow() {
		driver.close();
		sleep(2000);
	}

	public void moveBackToMainWindow() {
		System.out.println("Move Back to - mainWindow=" + mainWindow);
		driver.switchTo().window(mainWindow);
		sleep(2000);
	}
}
