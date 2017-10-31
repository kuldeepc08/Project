package PeerAppium.PeerAppium;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

public class Runpeerappium {
	public static final String USERNAME = System.getenv("SAUCE_USERNAME");//aniketk
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");//15680a59-4dda-41ad-858f-10f610680494
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	  private WebDriver driver;

	    @BeforeMethod
	    public void setUp() throws Exception {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("platformVersion", "5.0");
		    capabilities.setCapability("deviceType","phone");
		    capabilities.setCapability("browserName", "chrome");
		    capabilities.setCapability("deviceOrientation", "portrait");
		    capabilities.setCapability("appiumVersion", "1.6.5");
		//    capabilities.setCapability("phoneOnly", "true");
		    capabilities.setCapability("waitForAppScript", true); 
	        capabilities.setCapability("testobject_api_key", "8CEBB64282A54B4DBC639813D1BB03AF");
	        capabilities.setCapability("testobject_device", "Samsung Galaxy S4 Emulator"); 
	        driver = new AndroidDriver(new URL(URL), capabilities);
	    }

	   @Test
	    public void testMethod() throws InterruptedException {
	    	 Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
				String browserName = cap.getBrowserName().toLowerCase();
				System.out.println("browserName   "+browserName);
			signUp lessonPage = new signUp(driver);
				lessonPage.openUrl();
	    }

	    /* We disable the driver after EACH test has been executed. */
	    @AfterMethod
	    public void tearDown(){
	        driver.quit();
	    }

	
}
