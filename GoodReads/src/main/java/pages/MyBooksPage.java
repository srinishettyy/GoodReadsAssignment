package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBooksPage extends BaseClass{
	FileUtility fileutils = new FileUtility();
	WebDriver driver;
	public MyBooksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//a[text()='My Books']")
	private WebElement myBooksButton;
	
	@FindBy(xpath="//a[contains(@title,'The Monk Who Sold His Ferrari: A Fable About Fulfilling Your Dreams and Reach')]/../../..//a/img[@title='Remove from my books']")
	private WebElement removeBookButton;
	
	@FindBy(xpath="//ul[@class='personalNav']//span[@class='headerPersonalNav__icon']")
	private WebElement profileIconButton;
	
	@FindBy(xpath="//div[@class='siteHeader__subNav siteHeader__subNav--profile gr-box gr-box--withShadowLarge']/ul//a[text()='Sign out']")
	private WebElement signOutButton;
	
	public void removeBookFromMyBooks() throws InterruptedException {
		Thread.sleep(3000);
		myBooksButton.click();
		webutils.elementVisibility(driver, removeBookButton);
		removeBookButton.click();
		driver.switchTo().alert().accept();
	}
	
	public LoginPage logout() {
		webutils.elementVisibility(driver, profileIconButton);
		profileIconButton.click();
		signOutButton.click();
		return new LoginPage(driver);
	}
	
}
