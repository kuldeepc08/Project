package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestDocument extends Page {
	
	public RequestDocument(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-request-doc/div/div"));
		return panel;
	}
	
	public void requestQuestionHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Area Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowRequestQuestion()
	{
		frames();
		WebElement content = mainPanel().findElement(By.xpath("//app-display-request-doc/div/div/p/p"));
		System.out.println("Content below Request Document is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	
	public void learnMoreArea()
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
				(By.xpath("//app-display-request-doc/div/div/div[3]/div/p/p"));
		System.out.println("Learn more Text for Area Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void sendrequestToUpload()
	{
		frames();
		WebElement request = mainPanel().findElement(By.id("recipients"));
		System.out.println(request.isSelected());
		
		if (request.isSelected()==true)
		{
			WebElement enterEmail = mainPanel().findElement(By.id("recipients"));
			System.out.println("Placehoder - " +enterEmail.getAttribute("placeholder"));
			enterEmail.sendKeys(StaticClass.email);
		}
		driver.switchTo().defaultContent();
	}
	
	public void checkSubject()
	{
		frames();
		WebElement subject = mainPanel().findElement(By.id("subject"));
		System.out.println(subject.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}
	public void allFuntionsRequestQuestions()
	{
		requestQuestionHeader();
		//contentBelowRequestQuestion();
		learnMoreArea();
	//	learnMoreText();
		sendrequestToUpload();
		checkSubject();
		clickOnContinue();
		
	}
	
	
}
