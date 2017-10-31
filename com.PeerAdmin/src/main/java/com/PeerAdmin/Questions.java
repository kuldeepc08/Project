package com.PeerAdmin;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PeerAdmin.Controller.RunSauceLabPeerAdmin;

public class Questions {
	{
		final ChallengeAns objChallengeAns = new ChallengeAns();
		objChallengeAns.setQues1("What was the color of your first car?");
		objChallengeAns.setQues2("What was the make and model of your first car?");
		objChallengeAns.setQues3("In what city or town did you meet your significant other?");
		
		objChallengeAns.setAns1("a");
		objChallengeAns.setAns2("a");
		objChallengeAns.setAns3("a");
		
		   List<WebElement> element = RunSauceLabPeerAdmin.driver.findElements(By.cssSelector("#signinFormQuestions>h5"));
		   System.out.println(element.size());
		   if(element.size()==2)
		   {
		   String first = element.get(0).getText();
		   System.out.println(first);
		   System.out.println(objChallengeAns.getQues1());
		   
		   
		        if(first.equals(objChallengeAns.getQues1()))
		        {
		        	System.out.println("H1" + objChallengeAns.getAns1());
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns1());
		        	
		        }
		        else if(first.equals(objChallengeAns.getQues2()))
		        {
		        	System.out.println("H2" + objChallengeAns.getAns2());
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns2());
		        }
		        else if(first.equals(objChallengeAns.getQues3()))
		        {
		        	System.out.println("H3"+ objChallengeAns.getAns3());
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a1")).sendKeys(objChallengeAns.getAns3());
		        }
		        
		        
		        String second = element.get(1).getText();
				   
		        if(second.equals(objChallengeAns.getQues1()))
		        {
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns1());
		        }
		        else if(second.equals(objChallengeAns.getQues2()))
		        {
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns2());
		        }
		        else if(second.equals(objChallengeAns.getQues3()))
		        {
		        	RunSauceLabPeerAdmin.driver.findElement(By.id("a2")).sendKeys(objChallengeAns.getAns3());
		        }
		   }
		
	}

}
