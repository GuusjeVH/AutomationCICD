package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	
		@Test(dataProvider = "getData", groups = {"Purchase"})
		public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		
		
			ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(input.get("product"));
			CartPage cartPage = productCatalogue.goToCartPage();
		
			Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToCheckout();
			checkoutPage.selectCountry("Netherlands");
			ConfirmationPage confirmationPage = checkoutPage.placeOrder();
			String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}	
		
		@Test(dependsOnMethods = {"submitOrder"})   //this depends on methods makes sure to run that @test first, so first submitOrderTest will run and then this test will run
		public void OrderHistoryTest() {
			ProductCatalogue productCatalogue = landingPage.loginApplication("guusje@test.com", "Testing123.");
			OrderPage orderPage = productCatalogue.goToOrdersPage();
			Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
			
		}
		
		@DataProvider
		public Object[][] getData() throws IOException {

			
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};    //with the [][] we have created a two dimensional array, and in the curly brackets we enter the data, the tests in this class will then run twice, each time with a different data set
		}
		
		
		
		
		
		//Below are two ways to also add a dataprovider, first is hardcoding the values, second is creating hashmaps manually
		//we have commented these out since the dataprovider we have created above is more efficient, is also creates hashmaps but with an external Json file
//		@DataProvider
//		public Object[][] getData() {
//			return new Object[][] {{"guusje@test.com", "Testing123.", "ZARA COAT 3"}, {"testguus@test.com", "Testing123.", "ADIDAS ORIGINAL"}};
//		}
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "guusje@test.com");
//		map.put("password", "Testing123.");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "testguus@test.com");
//		map1.put("password", "Testing123.");
//		map1.put("product", "ADIDAS ORIGINAL");
		
	}


