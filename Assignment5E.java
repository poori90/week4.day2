package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5E {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load the URL 
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		// Switching to Frame 1
		driver.switchTo().frame(0);
		
		  WebElement element =
		  driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		  WebElement  element2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]")); 
		  builder.dragAndDrop(element, element2).perform();
		
		 
		System.out.println("Able to sort the items using Actions ");
	}

}
