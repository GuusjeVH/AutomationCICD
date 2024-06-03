package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

		@Test(groups = {"ErrorHandling"}, retryAnalyzer = rahulshettyacademy.TestComponents.Retry.class)
		public void LoginErrorValidation() throws IOException, InterruptedException {
		
			
		landingPage.loginApplication("guusje@test.com", "Testing1223."); //wrong password so we are expecting an error
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		}	
		
		@Test
		public void ProductErrorValidation() throws IOException, InterruptedException {
			
			String productName = "ZARA COAT 3";
			
		
			ProductCatalogue productCatalogue = landingPage.loginApplication("testguus@test.com", "Testing123.");
			
			List<WebElement> products = productCatalogue.getProductList();
			
			productCatalogue.addProductToCart(productName);
			
			CartPage cartPage = productCatalogue.goToCartPage();
			
			Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33"); //Wrong product name, so expected an error
			Assert.assertFalse(match);
			
			}	
	}


