package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AreaQuestion{
	WebDriver driver;

	public AreaQuestion(WebDriver driver)
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
				(By.xpath("//app-dynamic-question/app-display-area/div/div"));
		return panel;
	}
	
	public void areaQuestionHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Area Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void valueSendToTextBox()
	{
		frames();
		WebElement textone = mainPanel().findElement(By.cssSelector("#area1"));
		textone.sendKeys("12");
		WebElement textTwo = mainPanel().findElement(By.cssSelector("#area2"));
		textTwo.sendKeys("14");
		
		WebElement textThree = mainPanel().findElement(By.cssSelector("select#unitofmeasure"));
		Select objSelect = new Select(textThree);
		List<WebElement> element = objSelect.getOptions();
		for (int i = 0; i < element.size(); i++) {
			System.out.println("All Options from DropDown - " +element.get(i).getText());
		}
		objSelect.selectByIndex(1);
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
		WebElement learnMoreText = mainPanel().findElement(By.xpath("//app-display-area/div/div/div[3]/div/p/p"));
		System.out.println("Learn more Text for Area Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		valueSendToTextBox();
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}

	public void allFuntionsAreaQuestions()
	{
		areaQuestionHeader();
		valueSendToTextBox();
		/*learnMoreArea();
		learnMoreText();*/
		clickOnContinue();
	}
}
