package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickADate extends Page{
   
	public PickADate(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-date-picker/div/div"));
		return panel;
	}
	public void pickADateQuestionHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Matrix Multi Choice Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowPickADateQuestion()
	{
		frames();
		WebElement content = mainPanel().findElement(By.xpath("//app-display-date-picker/div/div/p/p"));
		System.out.println("Content below Matrix Multi Choice is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void sendDate()
	{
		frames();
		WebElement date = mainPanel().findElement(By.id("inputBeginDate"));
		date.sendKeys(StaticClass.date);
		driver.switchTo().defaultContent();
	}
	public void learnMoreSingleAndMultiple()
	{
		frames();
		WebElement learnMore = mainPanel().findElement(By.xpath("//app-display-date-picker/div/div/div[3]/a/span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		
		WebElement learnMoreText =  mainPanel().findElement(By.xpath("//app-display-date-picker/div/div/div[4]/div/p/p"));
		System.out.println("Learn more Text for Pick a Date Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button"));
		button.click();
		driver.switchTo().defaultContent();
	}
	
	public void allFuntionsPickaDate()
 	{   
		pickADateQuestionHeader();
		contentBelowPickADateQuestion();
		sendDate();
		learnMoreSingleAndMultiple();
		learnMoreText();
		clickOnContinue();
	}
}
