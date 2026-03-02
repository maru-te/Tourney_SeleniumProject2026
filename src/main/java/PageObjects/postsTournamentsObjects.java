package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postsTournamentsObjects {

	WebDriver driver;

	public postsTournamentsObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollAndClickWithSleep(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "(//div[contains(@class,'grid-cols-1')])[1]")
	private WebElement upcomingTournamentsCards;

	@FindBy(xpath = "//span[text()='Go To Tournament']")
	private WebElement goToTournamentsLink;

	@FindBy(xpath = "//p[text()='New Post']")
	private WebElement goToNewPost;

	@FindBy(id = "headline")
	private WebElement headline;

	@FindBy(css = "textarea[id='message']")
	private WebElement messageBox;

	@FindBy(xpath = "//p[text()='Post']")
	private WebElement post;

	@FindBy(xpath = "//h6[text()='No Posts To Show']")
	private WebElement noPostToShow;

	@FindBy(xpath = "(//button[@class='p-ripple p-button p-component p-button-icon-only p-button-secondary p-button-rounded p-button-outlined p-button-sm'])[1]")
	private WebElement settingsIcon;

	@FindBy(css = ".pi-trash")
	private WebElement trashIcon;

	@FindBy(xpath = "//p[text()='Delete']")
	private WebElement deleteConfirmButton;

	@FindBy(xpath = "//span[contains(@class,'pi-pencil')]")
	private WebElement editPencilIcon;

	@FindBy(xpath = "//p[text()='Save']")
	private WebElement saveButton;

	public WebElement scrollToUpcomingTournaments() {
		return upcomingTournamentsCards;
	}

	public WebElement scrollToNewPost() {
		return goToNewPost;
	}
	
	public void tournamentCards() {
		List<WebElement> cardsList = driver.findElements(By.xpath(
				"(//div[contains(@class,'grid grid-cols-1')])[1]/app-event-card/a/div/div[2]/div[2]/div[1]/div/div[1]/p"));

		for (int i = 0; i < cardsList.size(); i++) {
			String cardNames = cardsList.get(i).getText();
			if (cardNames.equalsIgnoreCase("Test World 2")) {
				cardsList.get(i).click();
				break;
			}
		}

		goToTournamentsLink.click();
	}

	public void createNewPost() throws InterruptedException {

		try {
			if (noPostToShow.isDisplayed()) {
				// No post available → create a new one
				System.out.println("No post found — creating a new post...");
				goToNewPost.click();
				headline.sendKeys("This is a new post");
				messageBox.sendKeys("Hello, this is message box, you can start texting the message");
				post.click();
				System.out.println("New post created successfully!");
			}
		} catch (Exception e) {
			System.out.println("Existing post found — deleting it...");
			settingsIcon.click();
			trashIcon.click();
			deleteConfirmButton.click();

			// Create a new post after deletion
			Thread.sleep(5000);
			System.out.println("Creating a new post after deletion...");
			goToNewPost.click();
			Thread.sleep(1500);
			headline.sendKeys("This is a new post");
			messageBox.sendKeys("Hello, this is message box, you can start texting the message");
			post.click();
			System.out.println("New post created successfully!");
		}

	}

	public void editPost() throws InterruptedException {

		try {
			if (noPostToShow.isDisplayed()) {
				goToNewPost.click();
				headline.sendKeys("This is a new post");
				messageBox.sendKeys("Hello, this is message box, you can start texting the message");
				post.click();
			}
		} catch (Exception e) {
			settingsIcon.click();
			trashIcon.click();
			deleteConfirmButton.click();

			// Create a new post after deletion
			Thread.sleep(5000);
			goToNewPost.click();
			Thread.sleep(1200);
			headline.sendKeys("This is a new post");
			messageBox.sendKeys("Hello, this is message box, you can start texting the message");
			post.click();
			Thread.sleep(5500);
			settingsIcon.click();
			editPencilIcon.click();
			headline.clear();
			headline.sendKeys("Edited Post");
			messageBox.clear();
			messageBox.sendKeys("This is a Edited version");
			saveButton.click();
			Thread.sleep(5500);
		}

	}

	public void deletePost() throws InterruptedException {

		try {
			if (noPostToShow.isDisplayed()) {
				goToNewPost.click();
				headline.sendKeys("This is a new post");
				messageBox.sendKeys("Hello, this is message box, you can start texting the message");
				post.click();
			}
		} catch (Exception e) {
			settingsIcon.click();
			trashIcon.click();
			deleteConfirmButton.click();

			// Create a new post after deletion
			Thread.sleep(5000);
			System.out.println("Creating a new post after deletion...");
			goToNewPost.click();
			headline.sendKeys("This is a new post");
			messageBox.sendKeys("Hello, this is message box, you can start texting the message");
			post.click();
			Thread.sleep(5000);
			settingsIcon.click();
			trashIcon.click();
			deleteConfirmButton.click();
			

		}

	}

}
