package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//2. Enter UserName and Password Using Id Locator
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 // 6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 
		 // 7. Click on Widget of From Contact
		 driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a")).click();
		// Handling the multiple windows 
		 Set<String> handles = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<String>();
			handlesList.addAll(handles);
			driver.switchTo().window(handlesList.get(1));
			Thread.sleep(3000);
		 //8. Click on First Resulting Contact
		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 System.out.println("First resulting contact selected");
		 driver.switchTo().window(handlesList.get(0));
		 //9. Click on Widget of To Contact
		 driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		 System.out.println("Clicked on To contact Widget");
		 
		 // handling the multiple windows
		 Set<String> handles1 = driver.getWindowHandles();
			List<String> handlesList1 = new ArrayList<String>();
			handlesList1.addAll(handles1);
			driver.switchTo().window(handlesList1.get(1));
			Thread.sleep(3000);
			
		 //10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		
		 System.out.println("second resulting contact selected");
		 
		 driver.switchTo().window(handlesList1.get(0));
		 
		 // 11. Click on Merge button using Xpath Locator
		 
		 driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		 System.out.println("Clicked on Merge button");
		 
		 //12. Accept the Alert
	 
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 System.out.println("handled the alert");
		 
		 //13. Verify the title of the page
		 
		 System.out.println("The Title of the Page :" + driver.getTitle());
		 
	}

}
