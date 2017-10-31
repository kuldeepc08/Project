package Questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PeerAdmin.Page;

public class InfoQuestions extends Page{

	public InfoQuestions(WebDriver driver){
	this.driver=driver;
	}
	public void inFrame() throws InterruptedException
	{
		WebElement fr = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("signInIframe")));
		driver.switchTo().frame(fr);
		
	}
	public void clickOnStartSurvey() throws InterruptedException
	{
		List<WebElement> element =driver.findElements(By.id("submit-margin"));
		System.out.println("Button size - " +element.size());

	}
}
