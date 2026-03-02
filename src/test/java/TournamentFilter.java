import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctions.BaseTest;
import PageObjects.LoginPageObjects;

import PageObjects.TournamentFilterObjects;

public class TournamentFilter extends BaseTest{
	
	@Test(priority=1)
	public void filterByExactTournamentName() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("Test World 2");
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Test World 2']")).getText(), "Test World 2");
	}
	
	@Test(priority=2)
	public void filterByPartialTournamentName() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.filterTournament("Test");
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'CML')]")).getText(), "Champions Masters League - CML 2026");
	}
	
	
	@Test(priority=3)
	public void filterIsCaseInsensitive() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("TeST wORLD");
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Test World']")).getText(), "Test World");
	}
	
	@Test(priority=4)
	public void filterWithNoMatchingResults() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("Hockey Legue");
		String noResultText = driver.findElement(By.cssSelector("h6[class*='text-sm'] span")).getText();
		Assert.assertTrue(noResultText.toLowerCase().contains("no result"));
		
	}
	
	
	@Test(priority=5)
	public void filterWithSpecialCharacters() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("@#$%^&");
		String noResultText = driver.findElement(By.cssSelector("h6[class*='text-sm'] span")).getText();
		Assert.assertTrue(noResultText.toLowerCase().contains("no result"));
	}
	
	
	@Test(priority=6)
	public void clearFilterRestoresAllTournaments() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("Test World 3");
		int filteredCount = SearchTournObj.getTournamentCount();
		System.out.println(filteredCount);
		Assert.assertEquals(filteredCount, 1);
		Thread.sleep(3000);
		SearchTournObj.clearTourName();
		SearchTournObj.pageRefresh(); // temporary Fix
		Thread.sleep(3000);

		int totalCount = SearchTournObj.getTournamentCount();
		System.out.println(totalCount);
		Assert.assertEquals(totalCount, 4);
	}
	
	@Test(priority=7)
	public void filterPersistenceAfterRefresh() throws InterruptedException {
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.clickLoginButton();	
		loginPage.login("rocky@playinga.com", "Open@123");
		Thread.sleep(8000);
		
		TournamentFilterObjects SearchTournObj = new TournamentFilterObjects(driver);
		SearchTournObj.scrollAndClickWithSleep(driver, SearchTournObj.scrollToFilterUpcomingTournaments());
		SearchTournObj.filterTournament("CML");
		int filteredCount = SearchTournObj.getTournamentCount();
		System.out.println(filteredCount);
		Assert.assertEquals(filteredCount, 1);
		Thread.sleep(3000);
		SearchTournObj.pageRefresh();
		Thread.sleep(3000);

		int totalCount = SearchTournObj.getTournamentCount();
		System.out.println(totalCount);
		Assert.assertEquals(totalCount, 4);
	}
}
