package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch URL "https://chercher.tech/practice/frames-example-selenium-webdriver"
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Switching to Frame 1 and identifying the text field and sending value
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Frames");
		
		//Switching to Frame 3 and selecting the checkbox
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		// Switching from the nested frame
		driver.switchTo().defaultContent();
		
		// Switching to Frame 2 and finding drop down element and selecting value from the drop down
		
		driver.switchTo().frame("frame2");
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		
	}

}
