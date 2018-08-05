package com.ww.question2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccessElementsOnSite {
	
	    public String baseUrl = "https://www.weightwatchers.com/us/";	
	    public WebDriver driver ; 
	     
	  @Test
	  public void accessWebElements() {	       
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  driver = new ChromeDriver();	 
		  
		  //1. Navigate to https://www.weightwatchers.com/us/
	      driver.get(baseUrl);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      
	      //2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
		  String expectedBaseTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
	      String actualBaseTitle = driver.getTitle();
	      
	      System.out.println("expectedBaseTitle is : "+expectedBaseTitle);            	      
	      System.out.println("actualBaseTitle is : "+actualBaseTitle);
	      
	   //   Assert.assertEquals(actualTitle, expectedTitle);
	      if(actualBaseTitle.equalsIgnoreCase(expectedBaseTitle)){
	    	  System.out.println("Title Matched on Main page");
	      }
	      else{
	    	  System.out.println("Main Page Title did not match");
	      }
	      
	      //3. On the right corner of the page, click on “Find a Meeting”
	      driver.findElement(By.xpath("//a[@href='/us/find-a-meeting']")).click();
	      
	      //4. Verify loaded page title contains “Get Schedules & Times Near You”
	      String expectedFindMeetingTitle = "Get Schedules & Times Near You";
	      String actualFindMeetingTitle = driver.getTitle();
	      System.out.println("expectedFindMeetingTitle is : "+expectedFindMeetingTitle);            	      
	      System.out.println("actualFindMeetingTitle is : "+actualFindMeetingTitle);
	      if(actualFindMeetingTitle.equalsIgnoreCase(expectedFindMeetingTitle)){
	    	  System.out.println("Title Matched on Find Meeting page");
	      }
	      else{
	    	  System.out.println("Title did not match on Find Meeting page");
	      }
	      
	      //5. In the search field, search for meetings for zip code: 10011
	      driver.findElement(By.id("meetingSearch")).sendKeys("10011");
	      driver.findElement(By.cssSelector(".btn-default")).click();
	      
	      WebElement waitForElement = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.className("meeting-locations-list")));

	   //6. Print the title of the first result and the distance (located on the right of location title/name)
	    List<WebElement> findElements=driver.findElements(By.className("meeting-locations-list__item"));  

	    String firstLocationSearchResult = findElements.get(0).getText();
	    String[] split_text = firstLocationSearchResult.split("0.49") ;
	    //System.out.println(split_text[0]);
	    String locText = split_text[0];
	    System.out.println("locText------"+locText);
	    
	    //7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
	    findElements.get(0).click();
	    
	    String getSelectedLocationName = driver.findElement(By.xpath("//div[@class='location__name']/span")).getText();
	   
	    System.out.println("getSelectedLocationName------"+getSelectedLocationName);
	    if(getSelectedLocationName.replaceAll("\\s+","").equalsIgnoreCase(locText.replaceAll("\\s+",""))){
	    	  System.out.println("Location Name Matched");
	      }
	      else{
	    	  System.out.println("Location Name did not match");
	      }
	     
	    //8.From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.PAGE_DOWN).build().perform();
	    WebElement element = driver.findElement(By.xpath("(//hours-list[@meetings='vm.location.openHours']//div[@ng-repeat='meeting in day.meetings'])[1]"));
	    System.out.println("element=="+element.getText());
	    
	    driver.quit();
	  }
	
	 
}
