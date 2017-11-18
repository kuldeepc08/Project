package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTextEntry{
	WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	public DynamicTextEntry(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-dynamictext/div/div"));
		return panel;
		
	}
	public void dynamicTextEntryHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector("div.heading-top>p"));
		System.out.println("Dynamic Text Entry question Title - " +header.getText());
		driver.switchTo().defaultContent();
	}
	
	public void enterTextToTextBox()
	{
		frames();
		WebElement text = mainPanel().findElement(By.xpath("//tag-input/div/div/tag-input-form/form/input"));
		text.sendKeys("Side Effects");
		driver.switchTo().defaultContent();
	}
	public void addResponseButton()
	{
		frames();
		WebElement buttonAddResponse = mainPanel().findElement(By.cssSelector("[type='submit']"));
		buttonAddResponse.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreDynamicSlider()
	{
		frames();
		WebElement learnMore = mainPanel().findElement(By.cssSelector(".learn-more.magtop10>a>span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement learnMoreText = mainPanel().findElement
				(By.xpath("//app-display-dynamictext/div/div/form/div[3]/a/span"));
		System.out.println("Learn more Text for Dynamic Slider Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void testSendValues()
	{
		frames();
		WebElement box = mainPanel().findElement
				(By.id("textentryinput"));
		box.sendKeys("Pooja");
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue() throws InterruptedException
	{
		frames();
		WebElement button = mainPanel().findElement(By.xpath("//label[contains(text(),'Continue')]"));
		button.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
	public void moveUp() throws InterruptedException
	{
		frames();
		WebElement element = driver.findElement(By.xpath
				("//app-display-single-choice-radio/div/div/app-display-header/div/p"));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);	 
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	
	public void allFunctionsDynaTextEntry() throws InterruptedException
	{
		dynamicTextEntryHeader();
		enterTextToTextBox();
		addResponseButton();
		testSendValues();
	//	learnMoreDynamicSlider();
		//learnMoreText();
		clickOnContinue();
		moveUp();
		
	}
}
