package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5A {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load the URL 
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		// Switching to Frame 1
		driver.switchTo().frame(0);
	
		System.out.println("Get inside the frame successfully");
		// pointing the Webelement to drag and drop
		WebElement element = driver.findElement(By.id("draggable"));
		// Retrieiving the Location 
		Point location = element.getLocation();
		System.out.println("Source Element location is :" + location);
		// dragging the element and drop it in frame 
		builder.dragAndDropBy(element, 150, 150).perform();
		System.out.println("Element is dragged successfully");
		
		
	}

}
