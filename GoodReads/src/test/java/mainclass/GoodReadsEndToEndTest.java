package mainclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBooksPage;

public class GoodReadsEndToEndTest extends BaseClass{
	
	@Test
	public void test() throws EncryptedDocumentException, IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		HomePage home = login.loginAsRegisteredUser();
		MyBooksPage myBooks = home.bookSearch();
		myBooks.removeBookFromMyBooks();
		myBooks.logout();
	}
}
