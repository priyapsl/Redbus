package com.mousehover;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestingDropDownTest {
 
	public static WebDriver driver =  null;
	public static Actions action = null;
	public static Map<String , String[]> menumap = new HashMap<String, String[]>();
	public String [] menu1 = {"Selenium IDE","Selenium RC","Selenium Grid","Selenium Server"};
	public String [] menu2 = {"Item 1","Item 2","Item 3","Item 4"};
	
	
	@BeforeSuite
	 public void menuDataprovider() {
		 menumap.put("Mastering Selenium", menu1);
		 menumap.put("Menu 2", menu2);
		 menumap.put("Menu 3", menu2);
		 menumap.put("Menu 4", menu2);
		 }
	
	@BeforeTest
	 public void openBroser() {
	 
		driver = new FirefoxDriver();
		driver.navigate().to("http://seleniummaster.com/sitecontent/seleniummenutest/seleniummenutest.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	  @Test
	  public void menuItem()
	  {
		 Set<String> keys = menumap.keySet();
		 Iterator<String> itr = keys.iterator();
		    while(itr.hasNext())
		    {
		    	String mainmenu = itr.next();
		    	
		    	System.out.println("Main Menu item is  " +mainmenu);
		    	
		    	String[] submenus = menumap.get(mainmenu);
		    	for(String submenu : submenus)
		    	{
		    		System.out.println("Sub Menu item is  " +submenu);
		    	    clickonMenu1(mainmenu,submenu);
		    	   
		    	   try{
		    			 Assert.assertEquals(driver.getTitle(), "Selenium Master LLC");
		    			 
		    		     }
		    		     catch(Throwable e)
		    		     {
		    		    	 Reporter.log("Page title is not matched");
		    		     }
		           waitforpage(500);
		    	}
		    }
	  }

	 
		//Abstract method to perform mouse over and click on Main menu  
	  public void clickonMenu1(String fmainmenu, String fsubmenu ){
	    
		 action = new Actions(driver);
		 WebElement main_menu_element = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/p[text()= '"+fmainmenu+"']"));
		 try {
			     if(main_menu_element.isDisplayed()){
			         
			    	 WebElement sub_menu_element = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/p[text()= '"+fmainmenu+"']"));
					  if(sub_menu_element.isDisplayed()){
			        
						 action.moveToElement(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/p[text()= '"+fmainmenu+"']"))).build().perform();
						 driver.findElement(By.linkText(fsubmenu)).click();
						 System.out.println(driver.getTitle());
						 waitforpage(100);
					     driver.navigate().back();
					     }
					   else{
						   Reporter.log("The submenu " + main_menu_element+ " is not present");
					       }
					}
			     else{
			    	 Reporter.log("The Mainmenu " + main_menu_element+ "is not present");
			     }
			         
			 }
			 catch(Exception e)
			 {
				e.printStackTrace();
			 }
	      }
      
	  //Abstract method to wait on page
	 public void waitforpage(long time){
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	   }
	 
	 @AfterTest
	  public void TearDown() {
		  
		  driver.close();
	}
}
