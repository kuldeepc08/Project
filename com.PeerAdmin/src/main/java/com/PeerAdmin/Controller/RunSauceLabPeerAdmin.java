package com.PeerAdmin.Controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.PeerAdmin.AreaQuestion;
import com.PeerAdmin.CommentQuestions;
import com.PeerAdmin.ConcurrentParameterized;
import com.PeerAdmin.DynamicSlider;
import com.PeerAdmin.DynamicTextEntry;
import com.PeerAdmin.InfoPanelQuestion;
import com.PeerAdmin.MatrixMultiChoice;
import com.PeerAdmin.MatrixQuestion;
import com.PeerAdmin.PickADate;
import com.PeerAdmin.SingleAndMultiple;
import com.PeerAdmin.SingleChoiceMulti;
import com.PeerAdmin.SingleandMultiPulldown;
import com.PeerAdmin.SliderQuesion;
import com.PeerAdmin.signUp;
import com.PeerAdmin.SurveyListing;
import com.PeerAdmin.TextEntry;
import com.PeerAdmin.eSign;


@RunWith(ConcurrentParameterized.class)
public class RunSauceLabPeerAdmin {
public static final String USERNAME = System.getenv("SAUCE_USERNAME");//aniketk
	
	public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");//15680a59-4dda-41ad-858f-10f610680494
	
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	/** * Represents the browser to be used as part of the test run. */
	
	protected String browser; 
	/** * Represents the operating system to be used as part of the test run.  * */
	
	protected String os; 
	
	/** * Represents the version of the browser to be used as part of the test run. */
	
	protected String version; 
	
	/** * Instance variable which contains the Sauce Job Id. */ 
	
	protected String sessionId; 
	
	/** * The {@link WebDriver} instance which is used to perform browser interactions with. */ 
	
	public static WebDriver driver;
	
	public RunSauceLabPeerAdmin(String os, String version, String browser) {
		super();
		this.os = os;
		this.version = version; 
		this.browser = browser;
	}
	
	
	@ConcurrentParameterized.Parameters
	public static LinkedList<String[]> browsersStrings() {
       
		LinkedList<String[]> browsers = new LinkedList<String[]>(); 
		
      browsers.add(new String[]{"Windows 10", "51", "firefox"}); 
       	
	// browsers.add(new String[]{"Windows 10", "56.0", "chrome"});
	 /* 	
	//   browsers.add(new String[]{"Windows 10", "54.0", "chrome"});
		
		/*browsers.add(new String[]{"Windows 10", "56.0", "chrome"});*/
		
	//	browsers.add(new String[]{"Windows 10", "11.0", "internet explorer"});
		
		//browsers.add(new String[]{"OS X 10.11","10.0","safari"});
		
		/*	browsers.add(new String[]{"OS X 10.11","46","firefox"});
		
		browsers.add(new String[]{"OS X 10.11","56","chrome"})*/;
		
		
		return browsers; 
		
	   }
	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser); 
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability(CapabilityType.PLATFORM, os); 
		capabilities.setCapability("name", "PeerProject");
		driver = new RemoteWebDriver(new URL(URL), capabilities); 
		this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
		String message = String.format("SauceOnDemandSessionID=%1$s",this.sessionId); 
		System.out.println(message); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.MINUTES);
		//((Options) driver).deleteAllCookies();
		//Dimension dimension = new Dimension(414, 640);
		
		/*galaxy S5 - 360*640
		 * 320*480
		 * nexus s5 - 414*732
		 * iphone 5 - 320*568
		 * iphnoe 6 - 375*667
		 * tab  size - 800*1280
		 * phone - 320*640 
		 * ipad - 768 * 1024
		 * ipad pro - 1024*1366
		 */
		//driver.manage().window().setSize(dimension);
		//driver.manage().window().maximize();
		}
	
	@Test
	public void testSampleTestCaseSauceLabs() throws InterruptedException
	{ 
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println("browserName   "+browserName);

		signUp lessonPage = new signUp(driver);
		lessonPage.openUrl();
		lessonPage.testClickOnStartNow();
		lessonPage.sendKeysToTextBox();
     	lessonPage.clickOnSignInButton();
    	lessonPage.questions();
		lessonPage.clickOnSignInButtonForQuestion(driver);
		lessonPage.sendPassword(driver);
		lessonPage.clickOnSignInButtonForLogin();
		
		Thread.sleep(30000);
		
		SurveyListing objSurveyListing = new SurveyListing(driver);
		objSurveyListing.surveyListing(); 
		
		InfoPanelQuestion objInfoPanelQuestion = new InfoPanelQuestion(driver);
		objInfoPanelQuestion.infoAllFunctions();
		
		SliderQuesion objSliderQuesion = new SliderQuesion(driver);
		objSliderQuesion.allFunctionsSlider();
		
		
		DynamicSlider objDynamicSlider = new DynamicSlider(driver);
		objDynamicSlider.allFuntionsDynaSlider();
		
		
		TextEntry objTextEntry = new TextEntry(driver);
		objTextEntry.allFunctionsTextEntry();
		
		//Dynamic Text Entry
		
		DynamicTextEntry objDynamicTextEntry = new DynamicTextEntry(driver);
		objDynamicTextEntry.allFunctionsDynaTextEntry();
		
		
		//Single and multiple question
		
		SingleAndMultiple  objSingleAndMultiple = new SingleAndMultiple(driver);
		objSingleAndMultiple.allFunctionsSingleAndMultiple();
		
			
		//Single and multiple with pulldown
		SingleandMultiPulldown objSingleandMultiPulldown = new SingleandMultiPulldown(driver);
		objSingleandMultiPulldown.allFunctionsSingleAndMultiple();		
		
		// single and multi choice
		SingleChoiceMulti objSIngleChoiceMulti = new SingleChoiceMulti(driver);
		objSIngleChoiceMulti.allFunctionsSingleAndmultipleChoice();
		
		
		//Matrix Question
		MatrixQuestion objMatrixQuestion = new MatrixQuestion(driver);
		objMatrixQuestion.allFunctionsMatrix();
		
		MatrixMultiChoice objMatrixMultiChoice = new MatrixMultiChoice(driver);
		objMatrixMultiChoice.allFunctionsMultiChoice();
		
		AreaQuestion objAreaQuestion = new AreaQuestion(driver);
		objAreaQuestion.allFuntionsAreaQuestions();
		
		CommentQuestions objCommentQuestions = new CommentQuestions(driver);
		objCommentQuestions.allFuntionsComment();
		
		PickADate objPickADate = new PickADate(driver);
		objPickADate.allFuntionsPickaDate();
		
		eSign objeSign = new eSign(driver);
		objeSign.allFuntionseeSignQuestions();
		
		}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
		}
	
	
	
}
