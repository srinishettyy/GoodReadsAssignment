package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	FileUtility fileutils = new FileUtility();
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[class='searchBox__input searchBox__input--navbar']")
	private WebElement searchBar;
	
	@FindBy(xpath="//button[@aria-label='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//span[contains(text(),'The Monk Who Sold His Ferrari: A Fable About Fulfilling Your Dreams and Reach')]")
	private WebElement bookName;
	
	@FindBy(xpath="//div[@class='Sticky']//span[text()='Want to read']")
	private WebElement wantToReadButton;
	
	
	public String homepageTitle() {
		return driver.getTitle();
	}
	
	public MyBooksPage bookSearch() throws EncryptedDocumentException, IOException {
		webutils.elementVisibility(driver, searchBar);
		searchBar.sendKeys(fileutils.readStringDataFromExcel("Sheet1", 4, 1));
		searchButton.click();
		bookName.click();
		webutils.elementVisibility(driver, wantToReadButton);
		wantToReadButton.click();
		return new MyBooksPage(driver);
	}
	
}
