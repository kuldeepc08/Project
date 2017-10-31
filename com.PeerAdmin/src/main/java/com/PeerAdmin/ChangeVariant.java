package com.PeerAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeVariant extends Page{

	public ChangeVariant(WebDriver driver)
	{
		this.driver= driver;
	}

	public void inFrame() throws InterruptedException
	{
		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("surveyIframe")));
		driver.switchTo().frame(fr);

	}
	public void selectCustomizeSurvey() throws InterruptedException
	{
		System.out.println("Starts of Redirect Question type ");
		System.out.println("Click on Customize survey button ");
		inFrame();
		Thread.sleep(5000);

		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[id='updateSurveyDivTab']")));
		fr.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println("remove from frame");
	}
	public void clickOnSelectSurvey() throws InterruptedException
	{
		System.out.println("Click on Select Survey Button- ");
		inFrame();
		Thread.sleep(5000);
		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[id='assingSurveyButtons']>[onclick='selectSurvey();']")));
		fr.click();

		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println("remove from frame");
	}

	public void clickSurvey() throws InterruptedException
	{
		System.out.println("Selecy Survey From the List");
		inFrame();
		WebElement ele = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tr[id='312']>.dataTableLink.sorting_1")));

		//tr[id='82'][code='elasticsearch']

		System.out.println("Switch to frame from elastic");
		ele.click();
		driver.switchTo().defaultContent();
		System.out.println("remove from table frame");
	}

	public void clickAddQuestion() throws InterruptedException
	{
		System.out.println("Click on Add Question button");
		inFrame();

		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Add Question']>i")));
		fr.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

	}
	public void addPanelNewRadioButton() throws InterruptedException
	{
		System.out.println("New Radio Button");
		inFrame();
		Thread.sleep(5000);
		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("newquestion")));
		System.out.println("Is New Radio Button is Selected ? " +fr.isSelected());
		driver.switchTo().defaultContent();	
	}
	public void selectChangeVariant() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		System.out.println("Select Change Variant Question Type");
		inFrame();
		Thread.sleep(5000);
		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("questionType")));
		actions.moveToElement(fr).click().build().perform();
		Select newSelect = new Select(fr);
		Thread.sleep(5000);
		newSelect.selectByValue("He");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();	
	}
	public void selectVariant() throws InterruptedException
	{
		System.out.println("Select Select Variant from Type");
		inFrame();
		Thread.sleep(5000);
		WebElement fr = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("changeVariantType")));
		Select newSelect = new Select(fr);
		Thread.sleep(5000);
		newSelect.selectByValue(StaticClass.variantType);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();	
	}
	public void clickSaveAndClose() throws InterruptedException
	{
		System.out.println("Click on Save Question");
		inFrame();
		Thread.sleep(5000);
		WebElement fr = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("saveQuestionButton")));
		fr.click();
	
		driver.switchTo().defaultContent();	
	}
}
