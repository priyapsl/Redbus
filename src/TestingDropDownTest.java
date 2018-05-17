import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestingDropDownTest {
 
	public static WebDriver driver =  null;
	public static Actions action = null;
	
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
		  clickonMenu1("Menu 2");
		  waitforpage(100);
		  
		  
	  }
  

	  @AfterTest
	  public void TearDown() {
		  
		  driver.close();
		 

	  }
		  
	 public void clickonMenu1(String item)
	{
	
		 action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.linkText(item))).moveToElement(driver.findElement(By.linkText("Item 2"))).click().build().perform();
		System.out.println(driver.getTitle());
	
        driver.navigate().back();
       
	}

	 
	 public void waitforpage(long time)
	 {
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
