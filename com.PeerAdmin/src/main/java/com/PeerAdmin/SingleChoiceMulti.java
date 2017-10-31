package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleChoiceMulti extends Page{
	
	public SingleChoiceMulti(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-multiple-choice/div/div"));
		return panel;
	}
	public void singlemultiChoiceHeader()
	{
		frames();
		
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Single and multiple question Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowSingleandMultiple()
	{
		frames();
		WebElement content = mainPanel().findElement(By.xpath("//app-display-multiple-choice/div/div/p/p"));
		System.out.println("Content below single and multiple is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void printAllDataoFCheckBox()
	{
		frames();
		List<WebElement> content = mainPanel().findElements(By.cssSelector("[type='checkbox']"));
		for (WebElement webElement : content) {
			System.out.println(webElement.getSize());
		}
		content.get(0).click();
		content.get(1).click();
		content.get(2).click();
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
				(By.xpath("//app-display-multiple-choice/div/div/div[5]/div/p/p"));
		System.out.println("Learn more Text for Dynamic Slider Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}
	public void allFunctionsSingleAndmultipleChoice()
	{
		singlemultiChoiceHeader();
		contentBelowSingleandMultiple();
		printAllDataoFCheckBox();
		learnMoreSingleAndMultiple();
		learnMoreText();
		learnMoreText();
		clickOnContinue();
	}
	
}
