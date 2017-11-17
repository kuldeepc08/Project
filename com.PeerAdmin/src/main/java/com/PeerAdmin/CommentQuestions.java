package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentQuestions {

	WebDriver driver;
	public CommentQuestions(WebDriver driver)
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
			WebElement panel = driver.findElement(By.xpath("//app-display-comment/div/div"));
			return panel;
		}
		
		public void commentQuestionHeader()
		{
			frames();
			WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
			System.out.println("Comment question Header is  - " +header.getText());
			driver.switchTo().defaultContent();
		}
		public void checkPlaceholder()
		{
			frames();
			String palceHolder = mainPanel().findElement(By.id("commentarea")).getAttribute("placeholder");
			System.out.println("PlaceHolder is - " +palceHolder);
			driver.switchTo().defaultContent();
		}
		public void CommentBox()
		{
			frames();
			WebElement ele = mainPanel().findElement(By.id("commentarea"));
			ele.clear();
			ele.sendKeys(StaticClass.Comment);
			driver.switchTo().defaultContent();
		}
		public void clearButton()
		{
			frames();
			WebElement ele = mainPanel().findElement
					(By.xpath("//app-display-comment/div/div/div[4]/span[1]/a/span"));
			ele.click();
			driver.switchTo().defaultContent();
		}
		public void learnMoreMatrix()
		{
			CommentBox();
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
					(By.xpath("//app-display-comment/div/div/div[4]/div/p/p"));
			System.out.println("Learn more Text for Comment Question - " +learnMoreText.getText());
			driver.switchTo().defaultContent();
		}
		public void clickOnContinue() throws InterruptedException
		{
			frames();
			WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
			button.click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
		}
		
		public void allFuntionsComment() throws InterruptedException
		{
			commentQuestionHeader();
			//checkPlaceholder();
			CommentBox();
			//clearButton();
			learnMoreMatrix();
			//learnMoreText();
			clickOnContinue();
		}

}
