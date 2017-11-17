package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleAndMultiple{
	WebDriver driver;
	
	public SingleAndMultiple(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-single-choice-radio/div/div"));
		return panel;
	}
	public void singleandMultipleHeader()
	{
		frames();
		
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Single and multiple question Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowSingleandMultiple()
	{
		frames();
		WebElement content = mainPanel().findElement
				(By.xpath("//app-display-single-choice-radio/div/div/p/p"));
		System.out.println("Content below single and multiple is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void selectRadioButton()
	{
		frames();
        List<WebElement> size= mainPanel().findElements(By.cssSelector("[type='radio']"));
        System.out.println("" +size);
        size.get(1).click();
        driver.switchTo().defaultContent();
		
	}
	public void learnMoreSingleAndMultiple()
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
				(By.cssSelector(".well>p>p"));
		System.out.println("Learn more Text for single and matrix Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}
	public void allFunctionsSingleAndMultiple()
	{
		singleandMultipleHeader();
		contentBelowSingleandMultiple();
		selectRadioButton();
		learnMoreSingleAndMultiple();
		learnMoreText();
		clickOnContinue();
	}
}
