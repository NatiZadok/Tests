package Common.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {

	public static Properties propUI = null;
	public static Properties propAPI = null;

	public static void initPropsFile() {
		propUI = new Properties();
		propAPI = new Properties();
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir") +"\\src\\Common\\data\\enviroment.properties" );
			propUI.load(input);
			InputStream inputapi = new FileInputStream(System.getProperty("user.dir") +"\\src\\Common\\data\\api.properties" );
			propAPI.load(inputapi);
			
		}
		catch(Exception err)
		{
			System.out.println("ERROR readPropStart:");
			System.out.println(err.getMessage());
		}
	}
	
	public static String BuildServerUrlAPI(String restApi)
	{
		return Utils.readPropStartAPI("ServerUrl")+restApi;
	}

	public static String BuildServerUrl(String urlPage)
	{
		return Utils.readPropStart("ServerUrl")+urlPage;
	}
	
	
	public static String readPropStartAPI(String key){
		return propAPI.getProperty(key);
	}
	
	public static String readPropStart(String key){
		return propUI.getProperty(key);
	}

	
    public static WebDriver getDriver(String browser){
        WebDriver driver = null;
        switch (browser){
        case "FireFox": 
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions fOptions = new FirefoxOptions();                                                
                        fOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                        driver =  new FirefoxDriver(fOptions);
                        break;
        case "Chrome":
                        WebDriverManager.chromedriver().setup();     
                        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
                        chromePrefs.put("profile.default_content_settings.popups", 0);  
                        chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\downloads");                   
                        ChromeOptions cOptions = new ChromeOptions();                           
                        cOptions.setExperimentalOption("prefs", chromePrefs);//for download location 
                        cOptions.addArguments("disable-infobars");//for disable-info bars
                        cOptions.addArguments("--disable-notifications");//for disable notifications popup
                        //cOptions.addArguments("--headless");//headless for running without browser                
                        cOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
                        driver = new ChromeDriver(cOptions);
                        break;
        case "Edge":
                        WebDriverManager.edgedriver().setup(); 
                        EdgeOptions eOptions = new EdgeOptions();                                                      
                        eOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
                        driver=new EdgeDriver(eOptions);
                        break;
        default:
                        System.out.println("No browser found");
                        break;
        }
        return driver;
}


	/**
	 * 
	 * @return formated date -> 2016-11-16 12:08:43
	 */
	public static String getNowDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		return dateFormat.format(date); 
	}
	
	/**
	 * 
	 * @return formated date -> 2016-11-16
	 */
	public static String getNowDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date); 
	}
}
