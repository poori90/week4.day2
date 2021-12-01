package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//1. Launch https://www.snapdeal.com/
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL 
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder =new Actions(driver);
			
			//2. Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("//li[@class='navlink lnHeight']//span[1]"));
		builder.moveToElement(men).perform();
			//3. Go to Sports Shoes
		WebElement shoe = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		builder.moveToElement(shoe).perform();
		shoe.click();
			//4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
		System.out.println("Count of Men's Sports Shoes :" + count);
			//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
			//6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value'])/li[2]")).click();
		Thread.sleep(5000);
			//7. Check if the items displayed are sorted correctly
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> priceList = new ArrayList<Integer>();
		boolean isSorted = false;
		for (int i = 0; i <= price.size() - 1; i++) {
			String text = price.get(i).getText();
			String value = text.replaceAll("[^0-9]", "");
			int number = Integer.parseInt(value);
			priceList.add(number);

		}

		List<Integer> priceList1 = new ArrayList<Integer>();
		priceList1.addAll(priceList);

		Collections.sort(priceList1);
		boolean sorted = priceList1.equals(priceList);

		if (sorted) 
			System.out.println("The price is sorted from Low to High");
		 else 
			System.out.println("The price is not sorted correctly");
		

		System.out.println(priceList);
		
			//8.Select the price range (900-1200)
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Color_s-Red']")).click();
		Thread.sleep(3000);
		String filter1 = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[1]")).getText();
		String filter2 = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[2]")).getText();
		System.out.println(filter1);
		System.out.println(filter2);

		
			//9.Filter with color Navy 
		if ((filter1.contains("Rs. 900 - Rs. 1200")) && (filter2.contains("Black"))) {
			System.out.println("Filter is applied correctly");
		}
		
			//10 verify the all applied filters 
		WebElement firstElement = driver.findElement(By.xpath("//picture[@class='picture-elem']//img"));
		
			//11. Mouse Hover on first resulting Training shoes
		builder.moveToElement(firstElement).perform();

			//12. click QuickView button
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
			//13. Print the cost and the discount percentage
		Thread.sleep(5000);
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String percent = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The Cost the Shoe: " +cost);
		System.out.println("The Discount Percentage of the shoe: "+percent);
			//14. Take the snapshot of the shoes.
		WebElement element = driver.findElement(By.xpath("//img[@itemprop='image']"));
		File source = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/shoe.png");
		FileUtils.copyFile(source, dest);
			//15. Close the current window
		driver.close();
			//16. Close the main window
		driver.quit();

	}

}
