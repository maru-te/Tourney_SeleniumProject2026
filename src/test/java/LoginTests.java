

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonFunctions.BaseTest;
import PageObjects.LoginPageObjects;

public class LoginTests extends BaseTest {
	
	//This is added in Mini tour branch - new branch
	

	@Test(priority = 1)
	public void loginWithEmptyEmailAndPassword() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton(); // to open login modal/page
		loginPage.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessageElement()));
		loginPage.assertErrorMessage("Enter a valid email address");
	}

	@Test(priority = 2)
	public void loginWithEmptyEmail() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("", "wrongPassword");
		loginPage.assertErrorMessage("Enter a valid email address");
	}

	@Test(priority = 3)
	public void loginWithEmptyPassword() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("Rocky@playinga.com", "");
		loginPage.assertErrorMessage("Enter password");
	}

	@Test(priority = 4)
	public void loginWithInvalidEmail() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("lokeshhh@playinga.com", "Open@123");
		loginPage.assertErrorMessage("Wrong Credentials: Invalid email or password");
	}

	@Test(priority = 5)
	public void loginWithInvalidPassword() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@1236789");
		loginPage.assertErrorToast("Invalid login credentials. Please enter correct credentials.");
	}

	@Test(priority = 6)
	public void loginSuccessful() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		loginPage.isSunIconVisible();

	}

	@Test(priority = 7)
	public void loginAndLogout() {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		loginPage.clickProfilePhoto();
		loginPage.clickLogout();
	}

}
