package com.PeerAdmin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class signUp {
	private WebElement startExerciseBtn;
	private WebElement SignInButton;
	protected final String baseUrl = "http://peermvc.peerplatform.org/portal/782#/loginHome";
	
	WebDriver driver;

	public signUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void openUrl() throws InterruptedException
	{
		driver.navigate().to(baseUrl);
		Thread.sleep(5000);
	}
	
	public void testClickOnStartNow() throws InterruptedException
	{
	startExerciseBtn = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated
					  (By.cssSelector("[type='button'][value='Start Now!'][ng-click='showLogin()']")));
	startExerciseBtn.click();
	Thread.sleep(5000);
	}
	
	public void sendKeysToTextBox() throws InterruptedException
	{	
		WebElement fr = (new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("u")));
		fr.clear();
		fr.sendKeys("parag@dynamisch.co");
		Thread.sleep(5000);
	}
	
	public void clickOnSignInButton() throws InterruptedException
	{
		SignInButton = (new WebDriverWait(driver, 30))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("loginSignInBtn")));
		SignInButton.click();
		Thread.sleep(5000);
	}
	
	public void questions() throws InterruptedException
	{
		final ChallengeAns objChallengeAns = new ChallengeAns();
		objChallengeAns.setQues1("What was the color of your first car?");
		objChallengeAns.setQues2("What was the make and model of your first car?");
		objChallengeAns.setQues3("In what city or town did you meet your significant other?");
		
		objChallengeAns.setAns1("a");
		objChallengeAns.setAns2("a");
		objChallengeAns.setAns3("a");
		System.out.println("U r in Question page");
		
		    Thread.sleep(5000);
		
		   List<WebElement> element = driver.findElements(By.cssSelector("#signinFormQuestions>h5"));
		   System.out.println(element.size());
		   if(element.size()==2)
		   {
		   String first = element.get(0).getText();
		   System.out.println(first);
		   System.out.println(objChallengeAns.getQues1());
		   
		   
		        if(first.equals(objChallengeAns.getQues1()))
		        {
		        	System.out.println("H1" + objChallengeAns.getAns1());
		        	driver.findElement(By.id("a1")).clear();
		        	driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns1());
		        	
		        }
		        else if(first.equals(objChallengeAns.getQues2()))
		        {
		        	System.out.println("H2" + objChallengeAns.getAns2());
		        	driver.findElement(By.id("a1")).clear();
		        	driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns2());
		        }
		        else if(first.equals(objChallengeAns.getQues3()))
		        {
		        	System.out.println("H3"+ objChallengeAns.getAns3());
		        	driver.findElement(By.id("a1")).clear();
		        	driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns3());
		        }
		        
		        
		        String second = element.get(1).getText();
				   
		        if(second.equals(objChallengeAns.getQues1()))
		        {
		        	driver.findElement(By.id("a2")).clear();
		        	driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns1());
		        }
		        else if(second.equals(objChallengeAns.getQues2()))
		        {
		        	driver.findElement(By.id("a2")).clear();
		        	driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns2());
		        }
		        else if(second.equals(objChallengeAns.getQues3()))
		        {
		        	driver.findElement(By.id("a2")).clear();
		        	driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns3());
		        }
		   }
		   
		   Thread.sleep(5000);
		
	}
	
	public void clickOnSignInButtonForQuestion(WebDriver driver)
	{
		try{
		WebElement element = 
				driver.findElement(By.xpath("//input[contains(@value,'Sign in')]"));
		element.click();
		
				  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendPassword(WebDriver driver)
	{
		try{
		   WebElement element = driver.findElement(
					  (By.cssSelector("#j_password")));
		       //element.clear();
			  element.sendKeys("Test123$$");
		  Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickOnSignInButtonForLogin() throws InterruptedException
	{
		System.out.println("Click on Sign in Button");
		WebElement element =(new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.elementToBeClickable
						  (By.cssSelector("#passwordBtn")));
		element.click();
		System.out.println("Clicked on Sign in Button?");
		  Thread.sleep(5000); 
	}	

}
