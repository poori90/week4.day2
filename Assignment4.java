package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//1.Take the the screenshot of the click me button of first frame
		//- find the Elements by tagname - iframe
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.tagName("iframe"));
		Thread.sleep(2000);
		File source = element.getScreenshotAs(OutputType.FILE);
		 File dest = new File("snaps/snap5.jpg");
		 FileUtils.copyFile(source, dest); 	
		 driver.switchTo().defaultContent();
		 
		//2.Find the number of frames
		//Store it in a list
		 List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			
			//Get the size of the list. (This gives the count of the frames visible to the main page)	
		 System.out.println("No.of Frames " + frames.size());
			
	}

}
