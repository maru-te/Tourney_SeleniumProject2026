package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateTournamentObjects {

	WebDriver driver;

	public void scrollAndClickWithSleep(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public CreateTournamentObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button/div/p[text()='Create Tournament']")
	private WebElement createTournamentButton;

	@FindBy(xpath = "//span[text()='Save & Publish']")
	private WebElement SavePublishButton;

	@FindBy(xpath = "//input[@placeholder='Contact email']")
	private WebElement emailField;

	@FindBy(id = "phone")
	private WebElement contactNumber;

	@FindBy(xpath = "//span[contains(text(),'valid contact')]")
	private WebElement errorMessage;

	@FindBy(css = "input[placeholder='Tournament Name']")
	private WebElement tournamentName;

	@FindBy(css = "input[class*='p-datepicker-input']:nth-of-type(1)")
	private WebElement startDate;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	private WebElement nextMonthArrow;

	@FindBy(xpath = "//span[contains(text(),'Enter a valid tournament start &')]")
	private WebElement startDateError;
	
	@FindBy(css="p-datepicker[formcontrolname='dueDt']")
	private WebElement regDueDate;
	
	@FindBy(xpath = "//span[contains(text(),'Enter a valid tournament due date')]")
	private WebElement dueDateError;
	
	@FindBy(xpath="//p[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//span[text()='Select sport']")
	private WebElement selectSport;
	
	@FindBy(css="input[placeholder='Event Name']")
	private WebElement eventName;

	public void clickCreateTournament() {
		createTournamentButton.click();
	}

	public WebElement getCreateTournamentButton() {
		return createTournamentButton;
	}

	public WebElement getSavePublishButton() {
		return SavePublishButton;
	}

	public void clickSavePublishButton() {
		SavePublishButton.click();
	}

	public void enterTourName(String tournName) {
		tournamentName.sendKeys(tournName);
	}

	public String getEmailid() {
		return emailField.getAttribute("value");
	}

	public void enterPhoneNumber(long number) {
		contactNumber.sendKeys(String.valueOf(number));
	}
	
	public void cancelTournamentForm() {
		cancelButton.click();
	}

	public boolean isPhoneNumberErrorDisplayed() {
		try {
			return errorMessage.isDisplayed();
		} catch (Exception e) {
			// Element not found or not visible → error not displayed
			return false;
		}
	}

	public void selectDay(String day) {
		WebElement date = driver
				.findElement(By.xpath("//span[contains(@class,'p-datepicker-day') and text()='" + day + "']"));
		date.click();
	}

	public void selectStartDate() throws InterruptedException {
		startDate.click();
		for (int i = 0; i < 3; i++) {
			Thread.sleep(200);
			nextMonthArrow.click();
		}
		
	}
	
	public void selectRegDueDate() throws InterruptedException {
		regDueDate.click();
		for (int i = 0; i < 3; i++) {
			Thread.sleep(200);
			nextMonthArrow.click();
		}
		
	}

	public void verifyStartDateErrorMessage(String expectedText) {
		String actualText = startDateError.getText().trim();
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passsed Successfully");
		}else {		
			Assert.fail();
		}

	}
	
	public void verifyRegDueDateErrorMessage(String expectedText) {
		String actualText = dueDateError.getText().trim();
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passsed Successfully");
		}else {		
			Assert.fail();
		}

	}
	
	
	public void selectSportsDropdown(String sport, String eventname) {
		selectSport.click();
		List<WebElement> sportsList = driver.findElements(By.xpath("//ul[contains(@class,'p-select-list')]/p-selectitem/li"));
		
		for(int i=0;i<sportsList.size();i++) {
			String sportName = sportsList.get(i).getText();
			if(sportName.equals(sport)) {
				sportsList.get(i).click();
				break;
			}
		}
		
		eventName.sendKeys(eventname);
		
	}

}
