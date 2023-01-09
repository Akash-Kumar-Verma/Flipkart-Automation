package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close_btn;

	@FindBy(xpath = "//*[@id=\\\"container\\\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement search_Box;

	@FindBy(xpath = "//*[@id=\\\"container\\\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	WebElement search_Btn;

	@FindBy(xpath = "//*[@id=\\\"container\\\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement item;

	@FindBy(xpath = "//*[@id=\\\"container\\\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	WebElement addtocart;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CloseLoginBanner() {
		close_btn.click();
	}

	public void ClickOnSearchBox() {
		search_Box.sendKeys("Iphone");
	}

	public void ClickOnSearchButton() {
		search_Btn.click();
	}

	public void CLickedOnItem() {
		item.click();
	}

	public void clickonaddTocart() {
		addtocart.click();
	}

}
