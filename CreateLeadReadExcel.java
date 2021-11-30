package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadReadExcel  extends DynamicBaseTest {
	
	@Test(dataProvider = "sendData")
	public void createlead(String company, String firstname , String lastname , String phNo) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		ReadExcel re = new ReadExcel();
		String[][] readData =re.readData("CreateLeadData");
	return readData;	
	
}
}
