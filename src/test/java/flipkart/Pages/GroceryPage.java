package flipkart.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroceryPage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")
	WebElement grocery;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement serach_box;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")
	WebElement pin_code;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")
	WebElement src_btn;

	public GroceryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnGroceryButton() {
		grocery.click();
	}

	public void SendThePinCode(String pincode) {
		WebElement pin = pin_code;
		pin.sendKeys(pincode);
		pin.sendKeys(Keys.ENTER);

	}

	public void SendItemsOnSearchBox(String Items) {
		WebElement search_item = serach_box;
		search_item.sendKeys(Items);
		search_item.sendKeys(Keys.ENTER);
	}

	public void clickonSRCButton() {
		src_btn.click();
	}

}
