import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RedBusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("i am on rebus");
		String Source = "Mumbai";
		
		 driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("Mumbai");
		 driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("goa");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label")).click();
	WebElement element = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[5]"));
	element.click();
	System.out.println(element.getText());
	driver.close();
	}

}
