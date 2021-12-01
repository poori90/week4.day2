package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--default-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		// 1) Load the URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2) Click on Try It Button (Hint: It is inside a frame)

		driver.switchTo().frame("iframeResult");
		System.out.println("Able to locate the Frame");
		// 3) Switch to the alert

		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();

		System.out.println("Switched to Alert");

		// 4) Type your name on the alert
		alert.sendKeys("Poornima");
		// 5) Click Ok on the alert
		alert.accept();
		// 6) Get the text appearing on the browser
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println("The Text appearing on browser is :" + text);
		// 7) Check if your name exist there !!

		if (text.contains("Poornima")) {
			System.out.println("My name is exisring in the Text appearing on the browser");
		} else
			System.out.println("My name is not existing  in the Text appearing on the browser ");

	}
}
