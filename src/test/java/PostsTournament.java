import org.testng.annotations.Test;

import CommonFunctions.BaseTest;
import PageObjects.LoginPageObjects;
import PageObjects.postsTournamentsObjects;

public class PostsTournament extends BaseTest{
	
	@Test(priority=1)
	public void createPost() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);	
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8500);
		
		postsTournamentsObjects tournObj = new postsTournamentsObjects(driver);
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToUpcomingTournaments());
		tournObj.tournamentCards();
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToNewPost());
		tournObj.createNewPost();
	}
	
	@Test(priority=2)
	public void editPost() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(10500);
		
		postsTournamentsObjects tournObj = new postsTournamentsObjects(driver);
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToUpcomingTournaments());
		tournObj.tournamentCards();
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToNewPost());
		tournObj.editPost();
	}
	
	@Test(priority=3)
	public void deletePost() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(10500);
		
		postsTournamentsObjects tournObj = new postsTournamentsObjects(driver);
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToUpcomingTournaments());
		tournObj.tournamentCards();
		tournObj.scrollAndClickWithSleep(driver, tournObj.scrollToNewPost());
		tournObj.deletePost();
	}

}
