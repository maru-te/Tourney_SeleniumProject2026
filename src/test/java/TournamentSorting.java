import org.testng.annotations.Test;

import CommonFunctions.BaseTest;
import PageObjects.LoginPageObjects;

public class TournamentSorting extends BaseTest{
	
	//Monday Excercise
	
//	sortTournamentsByNameAscending()
//
//	sortTournamentsByNameDescending()
//	
//	verifySortingPersistsAfterRefresh()

	
	@Test()
	public void sortTournamentsByNameAscending() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		
	}
	
	@Test
	public void sortTournamentsByNameDescending() {
		
		
	}

	@Test
	public void verifySortingPersistsAfterRefresh() {
		
		
	}
	
}
