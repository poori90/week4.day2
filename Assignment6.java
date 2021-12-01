package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//1) Go to https://www.nykaa.com/ 
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL 
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder =new Actions(driver);
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		WebElement search = driver.findElement(By.id("brandSearchBox"));
		search.click();
		builder.sendKeys("L'Oreal Paris").perform();
		
		//3) Click L'Oreal Paris 
		
		driver.findElement(By.xpath("//img[contains(@src,'lorealparis')]")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		 String title= driver.getTitle();
		 if(title.contains("L'Oreal Paris"))
		 {
			 System.out.println("Landed to L'Oreal Paris Page");
		 }
		
		//5) Click sort By and select customer top rated
		 driver.findElement(By.className("sort-name")).click();
		 driver.findElement(By.xpath("//span[text()='customer top rated']/following::div[1]")).click();
		
		 System.out.println("Sort By Value is selected from the drop down successfully");
		
		 //6) Click Category and click Hair->Click haircare->Shampoo 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='Category']")).click();	
		 System.out.println("Category clicked successfully");
		  driver.findElement(By.xpath("//span[text()='Hair']")).click();
		 // WebElement hair =driver.findElement(By.xpath("//span[text()='Hair Care']"));
		  //hair.click();
		  driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
			
			//builder.moveToElement(hair).perform();
			driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
			System.out.println("Shampoo clicked successfully");
		
		 //7) Click->Concern->Color Protection 
			/*
			 * Set<String> handles = driver.getWindowHandles(); List<String> handlesList =
			 * new ArrayList<String>(); handlesList.addAll(handles);
			 * driver.switchTo().window(handlesList.get(1));
			 */
		 
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		System.out.println("Color Protection selected successfully");
		  
		//8)check whether the Filter is applied with Shampoo 
		
		String filterText = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		if (filterText.contains("Shampoo")) {
			System.out.println("Filter applied correctly");
		
		// 9) Click on L'Oreal Paris Colour Protect Shampoo
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		
		//10) GO to the new window and select size as 175ml 
		 
		Set<String> newwindow = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>();
		windowlist.addAll(newwindow);
		driver.switchTo().window(windowlist.get(1));
		
		WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select s = new Select(size);
		s.selectByVisibleText("175ml");
		
		//11) Print the MRP of the product 
		String mrp = driver.findElement(By.xpath("(//span[text()='MRP:'])/following-sibling::span[1]")).getText();
		String mrp1= mrp.replaceAll("[^0-9]", "");
		System.out.println("The MRP of the Product is : " +mrp1 );
		
		// 12) Click on ADD to BAG 
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);
		
		
	    //13) Go to Shopping Bag 
		
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		
		// 14) Print the Grand Total amount 
		
		String total = driver.findElement(By.xpath("//div[@class='name medium-strong']/following-sibling::div"))
				.getText();
		String grandTotal = total.replaceAll("[^0-9]", "");
		System.out.println("The Grand Total Amount :" + grandTotal);
		
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		
		//16) Click on Continue as Guest 
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		// 17) Check if this grand total is the same in step 14 
		String finalTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
		String finalTotal1 = finalTotal.replaceAll("[^0-9]", "");	
		System.out.println("Grand Total Value printing from checkout window " +finalTotal1);

		if (grandTotal.equals(finalTotal1)) {
			System.out.println("Grand Total mathced with the total shown in Shopping Bag");
		}

		// 18) Close all windows
		driver.quit();
		System.out.println("All windows closed successfully");
			}
		
	}

}
