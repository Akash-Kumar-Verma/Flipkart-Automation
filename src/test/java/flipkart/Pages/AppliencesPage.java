package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppliencesPage {
	//div[contains(text(),'Adsun 80 cm (32 inch) HD Ready LED TV')]
	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[6]/a")
	WebElement applience;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement search_Box;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")
	WebElement search_Btn;

	@FindBy(xpath = "//div[contains(text(),'Adsun 80 cm (32 inch) HD Ready LED TV')]")
	WebElement productname;

	public AppliencesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnAppliances() {
		applience.click();
	}

	public void ClickOnSearchBox(String items) {
		search_Box.sendKeys(items);
	}

	public void clickOnSearchButton() {
		search_Btn.click();
	}

	public String getProductName() {
		return productname.getText();
	}

}
