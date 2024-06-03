package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	//Constructor
	public LandingPage(WebDriver driver)    //We have to add the constructor so we can use the driver object from our StandAloneTest, there we have created an object called LandingPage that has the driver as an argument
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElements will make sure the driver is passed in the PageFactory, so in the @FindBy below
	}
	//Below creation of WebElements is a possibility, however we can also use PageFactory which works the same way but is a bit more neat
	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// WebElelment password = driver.findElement(By.id("userPassword"))
	
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordElement;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordElement.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
