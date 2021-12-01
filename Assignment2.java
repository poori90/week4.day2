package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//Step1: Load ServiceNow application URL 
		
		driver.get("https://dev86680.service-now.com/navpage.do");
		Thread.sleep(5000);
		driver.switchTo().frame("gsft_main");
		System.out.println("frame has been selected");
		//Step2: Enter username (Check for frame before entering the username)
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//Step3: Enter password 
		
		driver.findElement(By.id("user_password")).sendKeys("Pass@1234");
		//Step4: Click Login
		
		driver.findElement(By.id("sysverb_login")).click();
		System.out.println("logged into appln sucessfully");
		//Step5: Search “incident “ Filter Navigator
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(5000);
		//Step6: Click “All”
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		//Step7: Click New button
		
		driver.findElement(By.id("sysverb_new")).click();
		//Step8: Select a value for Caller and Enter value for short_description
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> Handles = driver.getWindowHandles();
		List<String> HandlesList = new ArrayList<String>();
		HandlesList.addAll(Handles);
		driver.switchTo().window(HandlesList.get(1));
		System.out.println("child window has been selected");
		Thread.sleep(3000);
		driver.findElement(By.className("glide_ref_item_link")).click();
		driver.switchTo().window(HandlesList.get(0));
		System.out.println("parent window has been selected");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Added Description");
		System.out.println("description has been added");
		//Step9: Read the incident number and save it a variable
		
		String incidentnum = driver.findElement(By.id("incident.number")).getAttribute("value");
		//Step10: Click on Submit button
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incidentnum);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String Incident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		
		//Step 11: Search the same incident number in the next search screen as below
		
		if (Incident.equals(incidentnum)) {
			System.out.println("Incident Created Successfully");
		} else
			System.out.println("Incident Not Created");
		//Step12: Verify the incident is created successful and take snapshot of the created incident.
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/incident.png");
		FileUtils.copyFile(source, dest);

	}

}

