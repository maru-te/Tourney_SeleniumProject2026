package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TournamentFilterObjects {
	
	WebDriver driver;
	
	public TournamentFilterObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@placeholder='Filter'])[1]")
	private WebElement filterTournament;

	
	
	public void scrollAndClickWithSleep(WebDriver driver, WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		Thread.sleep(2000);
	}
	
	public WebElement scrollToFilterUpcomingTournaments() {
		return filterTournament;
	}
	
	
	public void filterTournament(String tournamentName) throws InterruptedException {
		 filterTournament.sendKeys(tournamentName);
		
	}

	
	public void clearTourName() {
		filterTournament.clear();
	}
	
	public int getTournamentCount() {
	    return driver.findElements(
	        By.cssSelector("app-event-card.ng-star-inserted a")
	    ).size();
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void timeSleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
}
