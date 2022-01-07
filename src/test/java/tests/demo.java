package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Shop_AllProducts.AllProducts;
import Shop_Cart.CartPage;
import Shop_Cart.CheckoutPage;
import Shop_Favourites.FavouritePage;
import Home.Footer;
import Home.Header;
import Home.HomePage;
import Home.LoginPage;
import Home.MyProfilePage;
import Shop_ProductDetail.PDP;
import Track_PurchaseAnalysis.PurchaseAnalysis;
import Shop_MainPage.SearchResultPage;
import Shop_StandardsCatalog.StandardsCatalog;
import Track_Calenders.Calendar;
import Track_MainPage.TrackPage;


import resources.base;

public class demo extends base  {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public SearchResultPage Srp;
	public static WebDriver driver;

	@Test(priority = 0)
  // delete fav//calender links2019
	public void ValidateLogin() throws IOException {
		driver=initializeDriver();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		 LoginPage lp= new LoginPage(driver);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getpassword().sendKeys(prop.getProperty("pswd"));
		lp.getloginbtn().click();	

		String TitleHome = driver.getTitle();


		try {
			Assert.assertEquals(TitleHome, "Shop - MarkITplace");

			Log.info("User Have Successfully Login To The Home Page");
		} catch (Throwable e) {

	
		}
	}

	
}
