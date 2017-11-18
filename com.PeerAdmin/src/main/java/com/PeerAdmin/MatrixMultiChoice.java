package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatrixMultiChoice {
  
	WebDriver driver;
	  public MatrixMultiChoice(WebDriver driver)
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
					(By.xpath("//app-display-multi-matrix/div/div"));
			return panel;
		}
		public void matrixQuestionHeader()
		{
			frames();
			WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
			System.out.println("Matrix Multi Choice Header is  - " +header.getText());
			driver.switchTo().defaultContent();
		}

		public void printMatrix() throws InterruptedException
		{
			frames();
			WebElement table = mainPanel().findElement(By.tagName("table"));
			WebElement data = table.findElement(By.tagName("td"));
			System.out.println("Matrix Table Content - \n \t"  +data.getText());
			List<WebElement> radio = data.findElements(By.cssSelector("[type='checkbox']"));
			int radioSize = radio.size();
			System.out.println(radioSize);
				radio.get(2).click();
				Thread.sleep(5000);
			driver.switchTo().defaultContent();
		}
		public void selectCheckBox()
		{
			frames();
			WebElement tabel = mainPanel().findElement(By.tagName("table"));
		    List<WebElement> tr = tabel.findElements(By.tagName("td"));
		    
		    for (int i = 0; i < tr.size(); i++) {
		    	WebElement data = tr.get(i).findElement(By.tagName("td"));
		    	System.out.println("Question Data - \t" +data.getText());
		    	WebElement tableRow = tr.get(i).findElement(By.tagName("td"));
		    	System.out.println("Table Data - \t" +tableRow.getText());
			} 
		    driver.switchTo().defaultContent();
		}
		public void learnMoreMatrix()
		{
			frames();
			WebElement learnMore = mainPanel().findElement(By.xpath("//app-display-learnmore/div/a/span"));
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
		
		public void allFunctionsMultiChoice() throws InterruptedException
		{
			matrixQuestionHeader();
			printMatrix();
		//	selectCheckBox();
			learnMoreMatrix();
			clickOnContinue();	
		}

		
}
