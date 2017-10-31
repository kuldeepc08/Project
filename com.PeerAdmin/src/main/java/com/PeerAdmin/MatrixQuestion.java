package com.PeerAdmin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatrixQuestion extends Page{

	public MatrixQuestion(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-single-matrix/div/div"));
		return panel;
	}
	public void matrixQuestionHeader()
	{
		frames();
		
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Matrix Question Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void contentBelowMatrix()
	{
		frames();
		WebElement content = mainPanel().findElement(By.xpath("//app-display-single-matrix/div/div/p/p"));
		System.out.println("Content below Matrix is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void printMatrix() throws InterruptedException
	{
		frames();
		WebElement table = mainPanel().findElement(By.tagName("table"));
		WebElement data = table.findElement(By.tagName("td"));
		System.out.println("Matrix Table Content - \n \t"  +data.getText());
		List<WebElement> radio = data.findElements(By.cssSelector("[type='radio']"));
		int radioSize = radio.size();
		System.out.println(radioSize);
		for (int i = 0; i < radioSize; i++) {
			radio.get(i).click();
			Thread.sleep(7000);
		}
		driver.switchTo().defaultContent();
	}
	public void selectRadioButton()
	{
		frames();
	    List<WebElement> td = mainPanel().findElements(By.tagName("table"));
	    
	    for (int i = 0; i < td.size(); i++) {
			
	    	WebElement data = td.get(i).findElement(By.tagName("td"));
	    	System.out.println("Question Data - \t" +data.getText());
		}    	
	}
	public void learnMoreMatrix()
	{
		frames();
		WebElement learnMore = mainPanel().findElement(By.xpath("//app-display-single-matrix/div/div/div[4]/a/span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement learnMoreText = mainPanel().findElement(By.xpath("//app-display-single-matrix/div/div/div[5]/div/p/p"));
		System.out.println("Learn more Text for Matrix Question - " +learnMoreText.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		driver.switchTo().defaultContent();
	}
	
	public void allFunctionsMatrix() throws InterruptedException
	{
		matrixQuestionHeader();
		contentBelowMatrix();
		printMatrix();
		//selectRadioButton();
		learnMoreMatrix();
		learnMoreText();
		clickOnContinue();
	}

}
