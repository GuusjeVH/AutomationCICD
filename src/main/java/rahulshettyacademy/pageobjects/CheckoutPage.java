package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input[placeholder='Select Country']")
	private WebElement countrySelect;       //private will hide the webelements for other classes, so it can only be used in the methods in this class
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[1]")
	private WebElement specificCountry;
	
	@FindBy(css = ".action__submit")
	private WebElement placeOrderButton;
	
	private By dropdownResults = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countrySelect, countryName).build().perform();
		waitForElementToAppear(dropdownResults);
		specificCountry.click();
	}
	
	public ConfirmationPage placeOrder() {
		placeOrderButton.click();
		return new ConfirmationPage(driver); 
	}
	
	
	/*
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "Netherlands").build().perform(); //don't forget to add build and perform when using Actions class
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results"))); //this wait method will wait until the webelement we mentioned is visible, only then will it continue to the next step
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	*/
}
