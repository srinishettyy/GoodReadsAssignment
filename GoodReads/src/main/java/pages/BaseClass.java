package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileutils = new FileUtility();
	public WebDriverUtility webutils = new WebDriverUtility();
	
	
	@BeforeMethod
	public void configBeforeMethod() throws EncryptedDocumentException, IOException {
		String browser = fileutils.readStringDataFromExcel("Sheet1", 0, 1);
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(fileutils.readStringDataFromExcel("Sheet1", 1, 1));
	}
	
	
	
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
