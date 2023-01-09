package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement login_btn;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement enter_mobile_number;

	@FindBy(xpath = "//button[contains(text(),'Request OTP')]")
	WebElement req_Otp;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnLogIn() {
		login_btn.click();
	}

	public void EnterMobileNumber(String mob) {
		enter_mobile_number.sendKeys(mob);
	}

	public void EnterInvalidMobileNumber() {
		enter_mobile_number.sendKeys("random");
	}

	public void RequestOTP() {
		req_Otp.click();
	}
}