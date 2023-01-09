package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileViewPage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]/div[1]/img[1]")
	WebElement mobile;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/a[1]/div[1]/img[2]")
	WebElement product;

	public MobileViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnMobileButton() {
		mobile.click();
	}

	public String getProductDetalis() {
		return product.getText();
	}

}
