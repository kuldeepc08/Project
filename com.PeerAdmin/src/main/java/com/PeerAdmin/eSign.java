package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eSign{
	
	WebDriver driver;
	public eSign(WebDriver driver)
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
	public void clickOnContinue() throws InterruptedException
	{
		frames();
		WebElement button = mainPanel().findElement(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		button.click();
		Thread.sleep(5000);
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
	public void clickOnYesButton() throws InterruptedException
	{
		frames();
		WebElement yesButton = mainPanel().findElement
				(By.xpath("//form/div/div[2]/div/div/div[2]/span[2]/a"));
		yesButton.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	
	//div/div[2]/div/div[5]/div[3]/a[2]
	public void clickOnTypeASign() throws InterruptedException
	{
		frames();
		WebElement yesSign = mainPanel().findElement
				(By.xpath("//app-display-esignature/div/form/div/div[2]/div/div[4]/a"));
		yesSign.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void sendSign() throws InterruptedException
	{
		frames();
		WebElement sign = mainPanel().findElement
				(By.id("textSignature"));
		sign.sendKeys("Pooja");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void selectFontName() throws InterruptedException
	{
		frames();
		WebElement sign = mainPanel().findElement
				(By.id("fontSignature"));
		Select objSelect = new Select(sign);
		objSelect.selectByVisibleText("HenryMorganHand");
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void clickOnApplyNowBtn() throws InterruptedException
	{
		frames();
		WebElement applyBtn = mainPanel().findElement
				(By.cssSelector(".save-btn2.pad6"));
		applyBtn.click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	public void clickOnSubmitBtn() throws InterruptedException
	{
		frames();
		WebElement submitBtn = mainPanel().findElement
				(By.cssSelector(".btn.panel-theme-button.btn-lg"));
		submitBtn.click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void moveDown() throws InterruptedException
	{
		frames();
		WebElement element = mainPanel().findElement(By.xpath
				("//app-display-esignature/div/form/div/div[2]/div/div[4]/a"));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);	 
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void allFuntionseeSignQuestions() throws InterruptedException
	{
		clickOnContinue();
		learnMoreArea();
		//learnMoreText();
		clickOnYesButton();
		moveDown();
		clickOnTypeASign();
		sendSign();
		selectFontName();
		clickOnApplyNowBtn();
		clickOnSubmitBtn();
		
	}

	
}
