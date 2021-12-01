package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5C {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load the URL 
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		// Switching to Frame 1
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		Point location=  element.getLocation();
		System.out.println("The poisiton of Web Element : " + location );
		builder.dragAndDropBy(element, 120,50).perform();
		System.out.println("Webelement is successfully updated the size");

	}

}
