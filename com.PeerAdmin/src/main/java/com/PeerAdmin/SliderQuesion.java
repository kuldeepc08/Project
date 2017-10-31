package com.PeerAdmin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderQuesion extends Page {

	public SliderQuesion(WebDriver driver)
	{
	this.driver=driver;
	}
	
	public void frames()
	{
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		WebElement frame = driver.findElement(By.id("surveysIframe"));
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		System.out.println("in the Frame?");
	}
	public WebElement mainPanel()
	{
		WebElement panel = driver.findElement
				(By.xpath("//app-display-slider/div/div"));
		return panel;
	}
	
	public void verifyHeader()
	{
		frames();
		if(mainPanel().findElements(By.cssSelector("div.heading-top>p")).size()!=0)
		{
		WebElement header = mainPanel().findElement(By.cssSelector("div.heading-top>p"));
		System.out.println("Slider Question Header is - " +header.getText());
		}
		else
		{
			System.out.println("No Slider header is present ");
		}
		driver.switchTo().defaultContent();
	}
	
	public void contentBelowSliderQuestion()
	{
		frames();
		if(mainPanel().findElements(By.xpath("//app-display-slider/div/div/p/p")).size()!=0)
		{
			WebElement contentText = mainPanel().findElement(By.xpath("//app-display-slider/div/div/p/p"));
			System.out.println("Content Below Slider Question - " +contentText.getText());
		}
		else
		{
			System.out.println("No Slider Content is present ");
		}
		driver.switchTo().defaultContent();
	}
	
	public void sliderValues()
	{
		frames();
		WebElement element = mainPanel().findElement(By.id("undefined-end-value"));
		System.out.println("Slider start value - " +element.getText());
		
		WebElement element1 = mainPanel().findElement(By.id("undefined-start-value"));
		System.out.println("Slider end value - " +element1.getText());	
		driver.switchTo().defaultContent();
	}
	
	public void sliderMove() throws InterruptedException
	{
		frames();
			WebElement source = 
					mainPanel().findElement(By.cssSelector("span#undefined-left-handle"));
		Actions objAction = new Actions(driver);
		objAction.click(source).build().perform();
		
		 for (int i = 0; i < 150; i++) {
			 objAction.sendKeys(Keys.ARROW_RIGHT).build().perform();
			 Thread.sleep(5000);
		 }
		     
		driver.switchTo().defaultContent();
	}
	public void learnMore()
	{
		frames();
		WebElement learn = mainPanel().findElement(By.xpath("//app-display-slider/div/div/div[3]/a/span"));
		learn.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement text = mainPanel().findElement
				(By.xpath("//app-display-slider/div/div/div[4]/div/p/p"));
		System.out.println("Learn more for Slider question- \n " +text.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinueButton()
	{
		frames();	
		WebElement click = mainPanel().findElement(By.cssSelector("a.btn.panel-theme-button.btn-lg"));
		click.click();
		driver.switchTo().defaultContent();
	}
	public void allFunctionsSlider() throws InterruptedException
	{
		verifyHeader();
		contentBelowSliderQuestion();
		sliderValues();
		learnMore();
		learnMoreText();
		clickOnContinueButton();
	}
	
}
