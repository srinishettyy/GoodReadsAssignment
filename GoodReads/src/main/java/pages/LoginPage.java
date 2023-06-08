package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	FileUtility fileutils = new FileUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sign In']")
	private WebElement signInLink;
	
	@FindBy(xpath="//button[contains(@class,'gr-button gr-button--d')]")
	private WebElement signInWithEmailButton;
	
	@FindBy(id="ap_email")
	private WebElement emailIdTextField;
	
	@FindBy(id="ap_password")
	private WebElement passwordTextField;
	
	@FindBy(css="input[id='signInSubmit']")
	private WebElement signInButton;
	
	@FindBy(id="auth-fpp-link-bottom")
	private WebElement forgotPassword;
	
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage	loginAsRegisteredUser() throws EncryptedDocumentException, IOException {
		signInLink.click();
		signInWithEmailButton.click();
		emailIdTextField.sendKeys(fileutils.readStringDataFromExcel("Sheet1", 2, 1));
		passwordTextField.sendKeys(fileutils.readStringDataFromExcel("Sheet1", 3, 1));
		signInButton.click();
		return new HomePage(driver);
	}
}
