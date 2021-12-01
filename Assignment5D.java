package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5D {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load the URL 
		driver.get("https://jqueryui.com/selectable ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder =new Actions(driver);
		
		driver.switchTo().frame(0); 
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		builder.click(item1).keyDown(Keys.CONTROL).click(item2).click(item5).click(item6).keyUp(Keys.CONTROL).perform();
		System.out.println("Able to select the identified items sucessfully ");
		}
		
	}


