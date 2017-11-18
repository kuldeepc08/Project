package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicSlider {

	WebDriver driver;
	public DynamicSlider(WebDriver driver)
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
				(By.xpath("//app-display-dynamic-slider/div/div"));
		return panel;
	}
	public void moveDown() throws InterruptedException
	{
		frames();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Continue')]"));
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.switchTo().defaultContent();
		 
	}
	
	public void dynamicSliderHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Dynamic Slider Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowDynamicSlider()
	{
		frames();
		WebElement content = mainPanel().findElement
				(By.xpath("//app-display-dynamic-slider/div/div/form/p/p"));
		System.out.println("Content below slider is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void learnMoreDynamicSlider()
	{
		frames();
		WebElement learnMore = mainPanel().findElement
				(By.xpath("//app-display-learnmore/div/a/span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement learnMoreText = mainPanel().findElement
				(By.xpath("//app-display-dynamic-slider/div/div/form/div[4]/div/p/p"));
		System.out.println("Learn more Text for Dynamic Slider Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void textBoxDynamicSlider() throws InterruptedException
	{
		frames();
		WebElement dynaTextBox = mainPanel().findElement
				(By.cssSelector("input[type='text'][minlength='1']"));
		dynaTextBox.sendKeys("test");	
		Thread.sleep(5000);
		List<WebElement> responses = driver.findElements(By.xpath("//ng2-dropdown-menu/div[1]"));
		responses.get(0).click();
		driver.switchTo().defaultContent();
	}
	public void addResponseButton() throws InterruptedException
	{
		frames();
		WebElement responseButton = mainPanel().findElement(By.cssSelector("button[type='submit']"));
		responseButton.click();
		driver.switchTo().defaultContent();
		moveDown();
	}
	public void clickOnContinue() throws InterruptedException
	{
		frames();
		//moveDown();
		WebElement button = mainPanel().findElement
				(By.xpath("//label[contains(text(),'Continue')]"));
		button.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	
	public void moveUp() throws InterruptedException
	{
		frames();
		WebElement element = driver.findElement(By.xpath
				("//app-display-text-entry/div/form/div/app-display-header/div/p"));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);	 
		driver.switchTo().defaultContent();
	}
	public void allFuntionsDynaSlider() throws InterruptedException
	{
		dynamicSliderHeader();
		//contentBelowDynamicSlider();
		learnMoreDynamicSlider();
		//learnMoreText();
		textBoxDynamicSlider();
		addResponseButton();
		clickOnContinue();
		moveUp();
	}
}
