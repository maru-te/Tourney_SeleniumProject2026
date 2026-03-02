import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctions.BaseTest;
import PageObjects.CreateTournamentObjects;
import PageObjects.LoginPageObjects;

public class CreateTournament extends BaseTest {

	@Test(priority=1)
	public void verifyMandatoryFieldsValidation() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);

		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.scrollAndClickWithSleep(driver,createTourn.getSavePublishButton());
		createTourn.clickSavePublishButton();
	}
	
	@Test(priority=2)
	public void verifyTournamentName() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.enterTourName("Tour Asia 2026");	
		
	}
	
	@Test(priority=3)
	public void verifyValidEmailFormat() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		Assert.assertEquals(createTourn.getEmailid(),"rocky@playinga.com");
	}
	
	
	@Test(priority=4)
	public void verifyValidContactNumber() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
			
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.enterPhoneNumber(9760504030L);
		//error message should not be displayed
		Assert.assertFalse(createTourn.isPhoneNumberErrorDisplayed(), "Enter valid contact number.");
	}
	
	@Test(priority=5)
	public void verifyTournamentDate() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.selectStartDate();
		createTourn.selectDay("3");
		createTourn.verifyStartDateErrorMessage("Enter a valid tournament start & end date");	
	}
	
	@Test(priority=6)
	public void verifyRegStartDate() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.selectRegDueDate();
		createTourn.selectDay("3");
		createTourn.verifyRegDueDateErrorMessage("Enter a valid tournament due date");
	}
	
	@Test(priority=7)
	public void cancelButtonFunctionality() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.scrollAndClickWithSleep(driver,createTourn.getSavePublishButton());
		createTourn.cancelTournamentForm();
	}
	
	@Test(priority=8)
	public void addSport() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.scrollAndClickWithSleep(driver,createTourn.getSavePublishButton());
		createTourn.selectSportsDropdown("Squash","U19");
		
	}
	
	@Test(priority=9)
	public void createTournament() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(2500);
		
		CreateTournamentObjects createTourn = new CreateTournamentObjects(driver);
		createTourn.scrollAndClickWithSleep(driver,createTourn.getCreateTournamentButton());
		createTourn.clickCreateTournament();
		createTourn.enterTourName("Test World");
   		createTourn.scrollAndClickWithSleep(driver,createTourn.getSavePublishButton());
		createTourn.selectSportsDropdown("Tennis", "Under 12");
		createTourn.scrollAndClickWithSleep(driver,createTourn.getSavePublishButton());
//		Thread.sleep(35000);
	}

}
