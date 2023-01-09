package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelPage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[7]/a")
	WebElement travel_btn;

	@FindBy(name = "0-departcity")
	WebElement depp_city;

	@FindBy(name = "0-arrivalcity")
	WebElement arr_city;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div[2]/form/div/button")
	WebElement search_btn;

	public TravelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnTravelButton() {
		travel_btn.click();
	}

	public void EnterDepartCity() {
		depp_city.sendKeys("New Delhi, DEL - Indira Gandhi Airport, India");
	}

	public void EnterArrivalCity() {
		arr_city.sendKeys("Singapore, SIN - Changi, Singapore");
	}

	public void ClickOnSearchButton() {
		search_btn.click();
	}

	public void enterFromLocation(String fromLocation) {
		// TODO Auto-generated method stub
		depp_city.sendKeys(fromLocation);
		
	}

	public void enterToLocation(String toLocation) {
		arr_city.sendKeys(toLocation);
	}

}
