package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fashion {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]/img[1]")
	WebElement fashion_btn;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]/div[2]/div[1]")
	WebElement all_type;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement shirt_btn;

	public Fashion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnFashionButton() {
		fashion_btn.click();
	}

	public void ClickOnAllTypeButton() {
		all_type.click();
	}

	public void CLickedOnShirt() {
		shirt_btn.click();
	}

}
