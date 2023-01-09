package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BecomeASellerPage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
	WebElement become_A_Seller_Btn;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement Mobile_no;

	@FindBy(xpath = "//div[contains(text(),'Start Selling')]")
	WebElement start_selling_Btn;

	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement again_Mo_num;

	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	WebElement emai_id;

	@FindBy(xpath = "//span[contains(text(),'Register & Continue')]")
	WebElement ragister;

	public BecomeASellerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnSellerButton() {
		become_A_Seller_Btn.click();
	}

	public void SendMobileNumber() {
		Mobile_no.sendKeys("");
	}

	public void ClickonStartSellingButton() {
		start_selling_Btn.click();
	}

	public void EnterAgainMobileNumber() {
		again_Mo_num.sendKeys("1234567890");
	}

	public void sendEmailId() {
		// TODO Auto-generated method stub
		emai_id.sendKeys("random@gmail.com");

	}

	public void ClickOnReginster() {
		ragister.click();
	}

}
