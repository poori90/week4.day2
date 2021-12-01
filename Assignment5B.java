package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5B {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load the URL 
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		// Switching to Frame 1
		driver.switchTo().frame(0);

		WebElement element = driver.findElement(By.id("draggable"));
		
		WebElement element2 = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(element, element2).perform();
		System.out.println("Successfully dragged and drpped the Webelement ");
	}

}
