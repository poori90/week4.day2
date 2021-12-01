package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--default-notifications");
		ChromeDriver driver =new ChromeDriver(options);
		//1) Open the browser with URL: https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2
		driver.get("https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//2) Click on the first book link
		WebElement book = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
		book.click();
			
		//	3) Print the number of window handles 
		 Set<String> allWindowHandles = driver.getWindowHandles();
		 List<String> allHandles = new ArrayList<String>(allWindowHandles);
		 System.out.println("The NO of Window Handles : " + allHandles.size());
		
		//	4) Switch the control to the second window
		 driver.switchTo().window(allHandles.get(1));
			//5) Print the title of the new window
		 System.out.println("The Title of New Window is : " + driver.getTitle());
			//6) Close all browsers
		 driver.quit();
		 System.out.println("successfully closed all browsers");

	}

}
