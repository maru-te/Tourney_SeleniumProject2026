package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPageObjects {

	WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Log In']")
    private WebElement loginButtonClk;

    @FindBy(css = "input[placeholder='Email Address']")
    private WebElement loginEmail;

    @FindBy(css = "input[placeholder*='Pass']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button/p[text()='Login']")
    private WebElement login;

    @FindBy(css = "span[class*='p-message-text']")
    private WebElement errorMessageLoginField;
    
    @FindBy(css=".p-toast-summary")
    private WebElement errorToastMessageLogin;

    
    @FindBy(css=".p-avatar-circle")
    private WebElement profileBanner;
    
    @FindBy(xpath="//span[text()='Log Out']")
    private WebElement logOut;
    
    // Action methods - mini tour code
    public void clickLoginButton() {
        loginButtonClk.click();
    }

    public void enterEmail(String email) {
        loginEmail.clear();
        loginEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        loginPassword.clear();
        loginPassword.sendKeys(password);
    }

    public void clickLogin() {
        login.click();
    }
    
    public WebElement getErrorMessageElement() {
        return errorMessageLoginField;
    }
    
    public WebElement getErrorToastElement() {
        return errorToastMessageLogin;
    }


    // ✅ Composite action method (place this here)
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
    
    public void assertErrorMessage(String expectedMessage) {
        Assert.assertEquals(getErrorMessageElement().getText(), expectedMessage);
    }
   
    public void assertErrorToast(String expectedMessage) {
    	 Assert.assertEquals(getErrorToastElement().getText(), expectedMessage);
    }
    
  
    public boolean isSunIconVisible() {
        return driver.findElement(By.className("pi-sun")).isDisplayed();
    }
    
    public void clickProfilePhoto() {
    	profileBanner.click();
    }
    
    public void clickLogout() {
    	logOut.click();
    }
    
    public void timeSleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
}
