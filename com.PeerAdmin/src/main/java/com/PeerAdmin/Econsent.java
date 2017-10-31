package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Econsent extends Page {
	
	public Econsent(WebDriver driver)
	{
		this.driver = driver;
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
		WebElement panel = driver.findElement(By.xpath("//app-display-esignature/div/form/div"));
		return panel;
	}
	public void learnMoreArea()
	{
		frames();
		WebElement learnMore = mainPanel().findElement(By.cssSelector(".learn-more.magtop10>a>span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement learnMoreText = mainPanel().findElement
				(By.xpath("//app-display-esignature/div/form/div/div[3]/div[3]/div/p/p"));
		System.out.println("Learn more Text for Area Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void allFuntionseConsentQuestions()
	{
		clickOnContinue();
		learnMoreArea();
		learnMoreText();
		clickOnContinue();
	}

	
}
