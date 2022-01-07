package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Home.Footer;
import Home.Header;
import Home.HomePage;
import Home.LoginPage;
import Home.MyProfilePage;
import Shop_AllProducts.AllProducts;
import Shop_Cart.CartPage;
import Shop_Cart.CheckoutPage;
import Shop_Favourites.FavouritePage;
import Shop_MainPage.SearchResultPage;
import Shop_ProductDetail.PDP;
import Shop_StandardsCatalog.StandardsCatalog;
import Track_Calenders.Calendar;
import Track_MainPage.TrackPage;
import Track_PurchaseAnalysis.PurchaseAnalysis;
import resources.base;

public class OldSmokeTests extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public SearchResultPage Srp;
	public static WebDriver driver;
	public CheckoutPage CO;
	PDP pp = new PDP(driver);
	By Welcomepg = By.xpath("//*[@alt='Not Your Traditional Reseller: Maximize Efficiencies, Cut Costs, Save Time']");
	By Cables = By.xpath("//div[@class='submenu-left']//a[contains(text(),'Cables')]");

	@Test(priority = 0, enabled = false)
	// delete fav//calender links2019
	@Parameters({ "username", "pswd", "url" })
	public void ValidateLogin(String username, String pswd, String url) throws IOException, InterruptedException {
		try {
			driver = initializeDriver();
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			LoginPage lp = new LoginPage(driver);
			driver.get(url);
			lp.getusernameie().sendKeys(username);
			lp.getpassword().sendKeys(pswd);
			lp.getloginbtn().click();
			Thread.sleep(5000);
			String TitleHome = driver.getTitle();
			CO = new CheckoutPage(driver);

			Assert.assertEquals(TitleHome, "Change Account - MarkITplace");
			System.out.println(TitleHome);

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			// SoftAssert s=new SoftAssert();
			// s.assertTrue(false, "Failed" + e.getMessage());
			String FailedLogin = e.getMessage();
			Assert.assertTrue(false, "Failed" + FailedLogin);
			System.out.println(FailedLogin);

		}

	}

	@Test(priority = 1, enabled = false)
	public void ValidateAudioCablesCategory() throws InterruptedException {

		try {

			AllProducts AP = new AllProducts(driver);
			WebDriverWait wt = new WebDriverWait(driver, 100);
			Header Head = new Header(driver);
			Thread.sleep(10000);
			wt.until(ExpectedConditions.elementToBeClickable(Head.getAllProductLink()));
			Head.getAllProductLink().click();
			System.out.println("hello");
			Thread.sleep(5000);

			wt.until(ExpectedConditions.elementToBeClickable(Cables));
			System.out.println("hello2");
			Actions action = new Actions(driver);
			WebElement web = driver.findElement(Cables);
			System.out.println("hello3");
			action.moveToElement(web).build().perform();
			Thread.sleep(5000);
			System.out.println("hello4");
			AP.getAudioCables().click();
			System.out.println("hello5");
			Thread.sleep(10000);

			String title5 = driver.getTitle();
			String expectedTitle = "Audio Cables - MarkITplace";

			Assert.assertEquals(title5, expectedTitle);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 1, enabled = false)
	public void ValidateFavoriteIcon() throws InterruptedException {
		try {
			Header hd = new Header(driver);
			WebDriverWait wt = new WebDriverWait(driver, 20);
			hd.getFavrtIcon().click();
			String title = driver.getTitle();
			String favoritesTitle = "Favorites - MarkITplace";

			Assert.assertEquals(title, favoritesTitle);

			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();

		}
	}

	@Test(priority = 2, enabled = false)

	public void ValidateSearching() throws InterruptedException {
		try {
			HomePage hp = new HomePage(driver);
			hp.getsearchbox().sendKeys("printers" + Keys.ENTER);

			String title3 = driver.getTitle();

			Thread.sleep(15000);
			Assert.assertEquals(title3, "Printers - MarkITplace");
			SearchResultPage Srp = new SearchResultPage(driver);

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 3, enabled = false)

	public void ValidateAddToCart() throws InterruptedException {
		try {
			SearchResultPage Srp = new SearchResultPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 50);

			wait.until(ExpectedConditions.visibilityOf(Srp.getProduct5Cart()));
			// Srp.getProduct5Cart().click();

			for (int j = 0; j < 5; j++) {// (//a[@data-product-type='PRODUCT'])[3]

				String nowr = "(//a[@data-product-type='PRODUCT'])[" + j + "]";

				By getnow1 = By.xpath(nowr);

				if (CO.isElementPresent(getnow1)) {
					Thread.sleep(4000);
					driver.findElement(getnow1).click();
					Thread.sleep(4000);
					break;
				}

			}

			By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");
			CO = new CheckoutPage(driver);
			if (CO.isElementPresent(pop)) {
				driver.navigate().back();

			}

			else {

				String parentWindowHandler = driver.getWindowHandle(); // Store your parent
				// window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()) {
					subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window

				wait.until(ExpectedConditions.visibilityOf(Srp.getCloseIcon()));

				Srp.getCloseIcon().click();

				driver.switchTo().window(parentWindowHandler);
				Thread.sleep(5000);
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 4, enabled = false)

	public void ValidateAddTofavorites() throws InterruptedException {
		try {
			SearchResultPage Srp = new SearchResultPage(driver);

			driver.findElement(By.xpath("(//a[contains(@id,'fav_btn_')])[1]")).click();

			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 5, enabled = false)

	public void ValidatePDPandAddToCart() throws InterruptedException {
		try {
			Thread.sleep(5000);
			Srp = new SearchResultPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 300);

			Thread.sleep(20000);

			// WebElement
			// a=driver.findElement(By.xpath("(//h2[contains(@id,'product-name-')])[2]"));

			// wait.until(ExpectedConditions.visibilityOf(a));
			// Thread.sleep(10000);
			// a.click();

			///

			for (int j = 0; j < 5; j++) {

				String now = "//h2[contains(@id,'product-name-')]";

				By getnow1 = By.xpath(now);

				if (CO.isElementPresent(getnow1)) {
					Thread.sleep(4000);
					driver.findElement(getnow1).click();
					Thread.sleep(4000);
					break;
				}

			}

			////

			String title5 = driver.getTitle();

			Thread.sleep(20000);

			PDP pp = new PDP(driver);
			// By Cartbtn=By.xpath("//a[@class='add_to_cart btn btn-primary show-for-tablet
			// modal-btn hide-for-print tt-wrapper']");
			// wait.until(ExpectedConditions.visibilityOf(pp.getCartbtn()));
			// driver.findElement(Cartbtn).click();
			Thread.sleep(5000);
			pp.getCartbtn().click();
			wait.until(ExpectedConditions.visibilityOf(pp.getCartClose()));
			Thread.sleep(5000);
			pp.getCartClose().click();
			Thread.sleep(5000);
		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 6, enabled = false)

	public void ValidateRecentViewLink() throws InterruptedException {
		try {
			FavouritePage fav = new FavouritePage(driver);
			Thread.sleep(10000);
			// fav.getRecentlyViewed().click();
			Thread.sleep(10000);
			String Title8 = driver.getTitle();
			WebDriverWait wait;
			wait = new WebDriverWait(driver, 180);
			Thread.sleep(3000);
			// wait.until(ExpectedConditions.titleContains("Recently Viewed Products -
			// MarkITplace"));
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 7, enabled = false)

	public void ValidateFooterLogo() throws InterruptedException {
		try {
			Footer ft = new Footer(driver);
			// hd.getHeadLogo().click();
			Thread.sleep(5000);
			ft.getFootLogo().click();

			String title5 = driver.getTitle();

			Assert.assertEquals(title5, "Shop - MarkITplace");
			Thread.sleep(5000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 8, enabled = false)
	public void ValidateMyProfNavigation() throws InterruptedException {
		try {
			MyProfilePage mpp = new MyProfilePage(driver);

			hp = new HomePage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();

			Thread.sleep(10000);
			mpp.getMyProfileLinkLink().click();
			Thread.sleep(10000);

			String title9 = driver.getTitle();
			String expectedMyProfTitle = "My Profile - MarkITplace";

			Assert.assertEquals(title9, expectedMyProfTitle);
			Thread.sleep(5000);
			mpp.getShippingAddressLink().click();
			Thread.sleep(10000);
			String title10 = driver.getTitle();
			String expectedShippingTitle = "Shipping Address - MarkITplace";

			Assert.assertEquals(title10, expectedShippingTitle);

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 9, enabled = false)

	public void ValidateHeaderLogo() throws InterruptedException {
		try {
			Header hd = new Header(driver);

			Actions act = new Actions(driver);

			Thread.sleep(7000);
			hd.getHeadLogo().click();
			Thread.sleep(3000);

			String title4 = driver.getTitle();

			Assert.assertEquals(title4, "Shop - MarkITplace");
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 10, enabled = false)
	public void ValidateStandardsCatalog() throws InterruptedException {
		try {
			Header head = new Header(driver);
			Thread.sleep(7000);
			head.getStanCatalogLink().click();
			Log.info("User has clicked on the Standard Catalog Navigation button from header");
			String title4 = driver.getTitle();
			String expectedTitle = "Standard Products - MarkITplace";

			Assert.assertEquals(title4, expectedTitle);

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 11, enabled = false)
	public void ValidateStandardsCatalogDetail() throws InterruptedException {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 20);
			StandardsCatalog St = new StandardsCatalog(driver);
			Thread.sleep(6000);

			St.getProduct2New().click();
			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 12, enabled = false)
	public void ValidateAllProduct() throws InterruptedException {
		try {
			Header Head = new Header(driver);

			WebDriverWait wt = new WebDriverWait(driver, 20);
			Thread.sleep(10000);
			wt.until(ExpectedConditions.elementToBeClickable(Head.getAllProductLink()));
			Head.getAllProductLink().click();
			Thread.sleep(5000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 14, enabled = false)
	public void ValidateResources() throws InterruptedException {
		try {
			Header Head = new Header(driver);
			Head.getResources().click();
			Thread.sleep(5000);
			String title5 = driver.getTitle();
			String expectedTitle = "Resources - MarkITplace";

			Assert.assertEquals(title5, expectedTitle);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 15, enabled = false)
	public void ValidateSpecialOffer() throws InterruptedException {
		try {
			Header Head = new Header(driver);
			Thread.sleep(10000);
			Head.getSpecialOffers().click();
			Thread.sleep(10000);
			Log.info("User has clicked on Special Offer Link from the header");
			String title5 = driver.getTitle();
			String expectedTitle = "Special Offers - MarkITplace";
			Thread.sleep(5000);
			Assert.assertEquals(title5, expectedTitle);
			Thread.sleep(5000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 16, enabled = false)
	public void ValidateCartPage() throws InterruptedException {
		try {
			Header Head = new Header(driver);
			Thread.sleep(7000);
			Head.getCartIcon().click();
			Thread.sleep(5000);
			Log.info("User has clicked on Cart Icon from the header");
			String title5 = driver.getTitle();
			String expectedTitle = "Cart - MarkITplace";
			Thread.sleep(5000);
			Assert.assertEquals(title5, expectedTitle);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 17, enabled = false)
	public void ValidateRemoveFromCart() throws InterruptedException {
		try {
			CartPage CP = new CartPage(driver);
			Thread.sleep(3000);
			for (int j = 0; j < 5; j++) {// (//a[@data-product-type='PRODUCT'])[3]

				String nowr = "(//a[@class='btn text-color cart-remove'])[" + j + "]";

				By getnow1 = By.xpath(nowr);

				if (CO.isElementPresent(getnow1)) {
					Thread.sleep(4000);
					driver.findElement(getnow1).click();
					Thread.sleep(4000);
					break;
				}

			}

			Boolean IsPresent = CP.getRemove1().isDisplayed();
			Boolean Expect = false;

			Assert.assertEquals(IsPresent, Expect);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 18, enabled = false)
	public void ValidateCheckoutProcess() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Header Head = new Header(driver);
			hp = new HomePage(driver);
			Srp = new SearchResultPage(driver);
			hp.getsearchbox().sendKeys("printers" + Keys.ENTER);

			String title3 = driver.getTitle();

			Thread.sleep(15000);
			Assert.assertEquals(title3, "Printers - MarkITplace");
			SearchResultPage Srp = new SearchResultPage(driver);

			// wait.until(ExpectedConditions.visibilityOf(Srp.getProduct5Cart()));
			// Srp.getProduct5Cart().click();

			// div[contains(@id,'post-body')]

			String gg = "//a[contains(@id,'add_to_cart_')]";

			System.out.print(gg);

			By getnow1 = By.xpath(gg);

			if (CO.isElementPresent(getnow1)) {
				Thread.sleep(4000);
				driver.findElement(getnow1).click();
				Thread.sleep(4000);
				PDP pp = new PDP(driver);

				Thread.sleep(10000);
				pp.getCartClose().click();
			}

			///////////

			wait.until(ExpectedConditions.elementToBeClickable(Head.getCartIcon()));
			Head.getCartIcon().click();
			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String expectedTitle = "Cart - MarkITplace";
			Thread.sleep(5000);
			Assert.assertEquals(title6, expectedTitle);
			Thread.sleep(5000);
			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			CartPage CP = new CartPage(driver);
			wait.until(ExpectedConditions.elementToBeClickable(CP.getCheckoutBtn1()));
			Thread.sleep(5000);
			CP.getCheckoutBtn1().click();
			Thread.sleep(3000);
			CheckoutPage CO = new CheckoutPage(driver);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
			CO.getPO().sendKeys((String.valueOf(x)));
			Thread.sleep(5000);
			CO.getCC().sendKeys("costcenter");
			Thread.sleep(5000);

			By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

			if (CO.isElementPresent(usediffshipAddress)) {

			} else {
				Thread.sleep(10000);

				for (int j = 1; j < 5; j++) {

					String now = "//div[@class='multiselect-address']//li[" + j + "]";
					// div[@class='multiselect-address']//li
					By getnow11 = By.xpath(now);

					if (CO.isElementPresent(getnow11)) {
						Thread.sleep(4000);
						driver.findElement(getnow11).click();
						System.out.print("hi");
						Thread.sleep(4000);
						break;
					}

				}

				// wait.until(ExpectedConditions.elementToBeClickable(CO.getShippingAddValue()));
				Thread.sleep(5000);
				// CO.getShippingAddValue().click();

				// wait.until(ExpectedConditions.elementToBeClickable(CO.getNewbtn()));
				// CO.getNewbtn().click();
				driver.findElement(By.linkText("Use This Address")).click();
				;
				Thread.sleep(10000);

			}

			wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
			CO.getAttention().sendKeys("abcTest");
			wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
			CO.getEmailConfirm().clear();
			CO.getEmailConfirm().sendKeys("saima.tabassum@arpatech.com");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(CO.getPlaceOrderBtn()));

			CO.getplaceorder().click();

			Thread.sleep(15000);
			By OrdercannotProcess = By.xpath(
					"//span[contains(text(),'Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.')]");
			if ((CO.isElementPresent(OrdercannotProcess))) {
				CO.getordererror().getText();
				Thread.sleep(5000);

				CO.getclose1().click();
				Thread.sleep(5000);
				System.out.print("order not successful");

			}

			// CO.getJavaClose().click();
			else if (driver.getTitle().contentEquals("Order Confirmation - MarkITplace")) {

			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 19, enabled = false)

	public void ValidateCheckoutHeaderLogo() throws InterruptedException {
		try {
			Header hd = new Header(driver);
			hd.getHeadLogo().click();
			Log.info("User has clicked the Logo from the header of the page");
			Thread.sleep(10000);
			String title4 = driver.getTitle();

			Assert.assertEquals(title4, "Shop - MarkITplace");
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();

		}
	}

	@Test(priority = 20, enabled = false)

	public void ValidateCheckoutFooterLogo() {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 50);

			Footer ft = new Footer(driver);
			// hd.getHeadLogo().click();
			wt.until(ExpectedConditions.elementToBeClickable(ft.getFootLogo()));
			ft.getFootLogo().click();
			Log.info("User has clicked the Logo from the footer of the page");
			String title5 = driver.getTitle();

			Assert.assertEquals(title5, "Shop - MarkITplace");
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 21, enabled = false)

	public void ValidateFooterLinks() throws InterruptedException {
		try {
			Footer ft = new Footer(driver);
			Thread.sleep(10000);

			ft.getFStandCatalogFF().click();
			WebDriverWait wt = new WebDriverWait(driver, 100);
			Thread.sleep(10000);
			ft.getFAllPrdctFF().click();

			String title2 = driver.getTitle();
			String exp2 = "All Products - MarkITplace";
			Thread.sleep(10000);
			Thread.sleep(5000);
			Assert.assertEquals(title2, exp2);

			ft.getFResourcesFF().click();

			Thread.sleep(15000);
			wt.until(ExpectedConditions.titleContains("Resources - MarkITplace"));
			String title3 = driver.getTitle();
			Thread.sleep(15000);
			Assert.assertEquals(title3, "Resources - MarkITplace");

			Thread.sleep(5000);

			ft.getFFavoritesFF().click();

			Thread.sleep(10000);

			wt.until(ExpectedConditions.titleContains("Favorites - MarkITplace"));
			String title5 = driver.getTitle();

			Assert.assertEquals(title5, "Favorites - MarkITplace");
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 22, enabled = false)

	public void ValidateTrackpage() throws InterruptedException {
		try {
			Header head = new Header(driver);
			Thread.sleep(10000);
			head.getTrackBtn().click();

			String title5 = driver.getTitle();
			String exp5 = "Track Dashboard - MarkITplace";
			Thread.sleep(5000);
			Assert.assertEquals(title5, exp5);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 23, enabled = false)

	public void ValidateordersPage() throws InterruptedException {
		try {
			Header head = new Header(driver);
			Thread.sleep(10000);

			Thread.sleep(5000);
			head.getOrderBtn().click();

			Thread.sleep(10000);
			String title5 = driver.getTitle();
			String exp5 = "Orders - MarkITplace";

			Assert.assertEquals(title5, exp5);
			Thread.sleep(5000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 24, enabled = false)

	public void ValidatePAPage() throws InterruptedException {
		try {
			Header head = new Header(driver);

			head.getTrackBtn().click();
			Thread.sleep(10000);

			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(head.getPAnalysisBtn()));

			head.getPAnalysisBtn().click();
			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Test(priority = 25, enabled = false)

	public void ValidatePAEmail() throws InterruptedException {
		try {
			PurchaseAnalysis PA = new PurchaseAnalysis(driver);
			WebDriverWait wait = new WebDriverWait(driver, 1000);

			Actions ab = new Actions(driver);
			Thread.sleep(5000);
			ab.click(driver.findElement(By.xpath("//a[@class='action-icon icon-mail']"))).release().perform();

			Thread.sleep(5000);

			WebElement download = driver.findElement(By.xpath("//div[@class='modal-mask']"));

			WebElement temp = download.findElement(
					By.xpath("(//div[@class='modal-content'])[4]//input[@type='text' and @name='email_addresses']"));
			Thread.sleep(3000);
			temp.sendKeys("ffhhffh@k.com");

			PA.getSendBtn().click();
			Thread.sleep(3000);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 26, enabled = false)

	public void ValidateCalendarPage() throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			Thread.sleep(5000);
			Header head = new Header(driver);
			TrackPage TP = new TrackPage(driver);
			Thread.sleep(7000);
			// head.getTrackBtn().click();
			wait.until(ExpectedConditions.visibilityOf(TP.getCalendarBtn()));
			Thread.sleep(10000);
			TP.getCalendarBtn().click();
			Thread.sleep(7000);
			Log.info("User has clicked on the Calendar button from the header of the page");
			String title5 = driver.getTitle();
			String exp5 = "Calendar Monthly View - MarkITplace";

			Assert.assertEquals(title5, exp5);

			Calendar CR = new Calendar(driver);

			// SF.assertEquals(CR.getMonthViewBtn1().isSelected(), true, "Monthly Tab is not
			// selected in the Calendar's Page");
			Thread.sleep(3000);
			Select se = new Select(CR.getCalendarDropdown());
			se.selectByVisibleText("2019");
			Thread.sleep(5000);
			By historyCTA1 = By.xpath("//span[contains(text(),'January')]");
			if (CR.isElementPresent(historyCTA1))

			{

				System.out.println("calender monthly present");
			}
			Thread.sleep(5000);
			WebElement a2 = driver.findElement(By.xpath("//span[contains(text(),'Detail view')]"));
			Thread.sleep(5000);
			a2.click();
			Thread.sleep(8000);
			By historyCTA = By.xpath("//li[contains(text(),'Sunday')]");
			if (CR.isElementPresent(historyCTA))

			{

				System.out.println("calender detail present");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 28, enabled = false)

	public void ValidateAllReportsLinks() throws InterruptedException {

		try {
			SoftAssert SF = new SoftAssert();
			Header head = new Header(driver);

			head.getTrackBtn().click();

			Thread.sleep(10000);

			WebElement web = driver.findElement(By.xpath("//a[@class='top-link'][contains(text(),'Reports')]"));
			// action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Actions actions = new Actions(driver);
			actions.moveToElement(web);
			actions.perform();
			// head.getReports().click();
			Thread.sleep(10000);
			/*
			 * driver.findElement(By.linkText("Assets")).click();
			 * 
			 * Thread.sleep(10000); String title5 = driver.getTitle(); String exp5 =
			 * "Assets Report - MarkITplace";
			 * 
			 * 
			 * Assert.assertEquals(title5, exp5);
			 * 
			 * 
			 * 
			 * head.getReports().click();
			 * 
			 * 
			 * Thread.sleep(10000); driver.findElement(By.linkText("Days to Ship")).click();
			 * Thread.sleep(10000);
			 * Log.info("User has clicked on the Days To Ship report from Report tab");
			 * String title6 = driver.getTitle(); String exp6 =
			 * "Days To Ship Report - MarkITplace";
			 * 
			 * Thread.sleep(5000); Assert.assertEquals(title6, exp6); Thread.sleep(5000);
			 * 
			 * head.getReports().click(); Thread.sleep(5000);
			 * driver.findElement(By.linkText("Expiration")).click();
			 * 
			 * Thread.sleep(5000); String title7 = driver.getTitle(); String exp7 =
			 * "Expiration Report - MarkITplace";
			 * 
			 * 
			 * Assert.assertEquals(title7, exp7);
			 * 
			 * 
			 * 
			 * 
			 * Thread.sleep(5000); head.getReports().click(); Thread.sleep(5000);
			 * driver.findElement(By.linkText("Inventory")).click();
			 * 
			 * Thread.sleep(10000); String title8 = driver.getTitle(); String exp8 =
			 * "Inventory Report - MarkITplace";
			 * 
			 * Thread.sleep(5000); Assert.assertEquals(title8, exp8);
			 * 
			 * 
			 * Thread.sleep(5000); head.getReports().click(); Thread.sleep(5000);
			 * driver.findElement(By.linkText("Invoices")).click(); Thread.sleep(10000);
			 * 
			 * String title9 = driver.getTitle(); String exp9 =
			 * "Invoices Report - MarkITplace";
			 * 
			 * Thread.sleep(5000); Assert.assertEquals(title9, exp9);
			 * 
			 * 
			 * Thread.sleep(5000); head.getReports().click(); Thread.sleep(5000);
			 * driver.findElement(By.linkText("Invoice Line")).click(); Thread.sleep(10000);
			 * 
			 * String title10 = driver.getTitle(); String exp10 =
			 * "Invoice Line Report - MarkITplace";
			 * 
			 * 
			 * Thread.sleep(5000); Assert.assertEquals(title10, exp10);
			 * 
			 * Thread.sleep(5000); head.getReports().click(); Thread.sleep(5000);
			 * driver.findElement(By.linkText("Licenses")).click();
			 * 
			 * Thread.sleep(10000); String title11 = driver.getTitle(); String exp11 =
			 * "Licenses Report - MarkITplace";
			 * 
			 * 
			 * 
			 * Assert.assertEquals(title11, exp11);
			 * 
			 * 
			 * Thread.sleep(5000); head.getReports().click(); Thread.sleep(5000); Actions
			 * builder=new Actions(driver); By
			 * Reports=By.xpath("//a[@class='top-link'][contains(text(),'Reports')]");
			 * 
			 * WebElement username=driver.findElement(Reports); Thread.sleep(3000);
			 * 
			 * 
			 * builder.moveToElement(username).perform(); Thread.sleep(10000);
			 * 
			 * WebElement rep=driver.findElement(By.xpath(
			 * "//nav[@class='section-navigation']//div[@data-submenu-id='reports']//ul[1]//li[10]"
			 * ));
			 * 
			 * rep.click();
			 * 
			 * 
			 * Thread.sleep(10000); String title12 = driver.getTitle(); String exp12 =
			 * "Orders Report - MarkITplace";
			 * 
			 * 
			 * 
			 * 
			 * Assert.assertEquals(title12, exp12);
			 * 
			 * Thread.sleep(5000); head.getReports().click();
			 */
			Thread.sleep(5000);
			driver.findElement(By.linkText("Order Line")).click();

			Thread.sleep(5000);
			String title13 = driver.getTitle();
			String exp13 = "Order Line Report - MarkITplace";

			Assert.assertEquals(title13, exp13);

			Thread.sleep(5000);
			By Reports = By.xpath("//a[@class='top-link'][contains(text(),'Reports')]");
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(Reports);
			action.moveToElement(we).build().perform();

			// head.getReports().click();

			Thread.sleep(10000);
			// driver.findElement(By.xpath("//body/div[2]/nav[2]/div[4]/div[1]/ul[2]/li[2]/a[1]")).click();
			// driver.findElement(By.cssSelector("div.master-track-area:nth-child(8)
			// nav.section-navigation.track-menu:nth-child(2)
			// div.submenu-container:nth-child(4) div.submenu.single.clearfix
			// ul.column:nth-child(2) li:nth-child(2) > a:nth-child(1)")).click();
			// body/div[2]/nav[2]/div[4]/div[1]/ul[2]/li[2]/a[1]
			// driver.findElement(By.xpath("//nav[@class='section-navigation']//div[@data-submenu-id='reports']//ul[2]//li[2]//a[1]")).click();
			// driver.findElement(By.xpath("//body/div[2]/nav[2]/div[4]/div[1]/ul[2]/li[3]")).click();
			driver.findElement(By.partialLinkText("Purchase Approval Re")).click();
			Thread.sleep(5000);
			String title14 = driver.getTitle();
			String exp14 = "Purchase Approval Requests (PAR) Report - MarkITplace";

			Assert.assertEquals(title14, exp14);

			/*
			 * WebElement we1 = driver.findElement(Reports);
			 * action.moveToElement(we1).build().perform();
			 * 
			 * //head.getReports().click(); WebElement ind = driver.findElement(By.
			 * cssSelector("div.master-track-area:nth-child(8) nav.section-navigation.track-menu:nth-child(2) div.submenu-container.active:nth-child(4) div.submenu.single.clearfix > ul.column:nth-child(2)"
			 * )); List<WebElement> li =ind.findElements(By.tagName("li")); //
			 * List<WebElement> li =
			 * driver.findElements(By.xpath("//body/div[2]/nav[2]/div[4]/div[1]/ul[2]"));
			 * 
			 * Thread.sleep(5000); //driver.findElement(By.xpath(
			 * "//nav[@class='section-navigation']//div[@data-submenu-id='reports']//ul[2]//li[3]"
			 * )).click(); //driver.findElement(By.partialLinkText("Qu")).click();
			 * //driver.findElement(By.xpath(
			 * "//body/div[2]/nav[2]/div[4]/div[1]/ul[2]/li[3]/a[1]")).click();
			 * 
			 * String lik=li.get(3).getText(); System.out.print(lik);
			 * 
			 * 
			 * Thread.sleep(5000); String title15 = driver.getTitle(); String exp15 =
			 * "Quotes Report - MarkITplace";
			 * 
			 * Thread.sleep(5000); Assert.assertEquals(title15, exp15);
			 */

			Thread.sleep(5000);
			WebElement we2 = driver.findElement(Reports);
			action.moveToElement(we2).build().perform();
			// head.getReports().click();;
			Thread.sleep(5000);
			// driver.findElement(By.xpath("//nav[@class='section-navigation']//div[@data-submenu-id='reports']//ul[2]//li[5]")).click();
			// driver.findElement(By.partialLinkText("Receiving Log")).click();
			driver.findElement(By.xpath("//body/div[2]/nav[2]/div[4]/div[1]/ul[2]/li[5]")).click();
			Thread.sleep(10000);
			String title16 = driver.getTitle();
			String exp16 = "Receiving Log Report - MarkITplace";

			Assert.assertEquals(title16, exp16);

			Thread.sleep(5000);
			head.getReports().click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Shipments")).click();
			Thread.sleep(10000);

			String title17 = driver.getTitle();
			String exp17 = "Shipments Report - MarkITplace";

			Assert.assertEquals(title17, exp17);

			Thread.sleep(5000);
			head.getReports().click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Standards")).click();
			Thread.sleep(10000);

			String title18 = driver.getTitle();
			String exp18 = "Standards Report - MarkITplace";

			try {
				Thread.sleep(5000);
				Assert.assertEquals(title18, exp18);

				Log.info("User have reached the Standards report after clicking on Standards link from report tab");
			} catch (Throwable e) {

				Thread.sleep(5000);
				head.getReports().click();
				Thread.sleep(5000);
				driver.findElement(By.linkText("Warranties")).click();

				Thread.sleep(10000);
				String title19 = driver.getTitle();

			}

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 29, enabled = false)
	public void ValidateSavedReports() throws InterruptedException {
		try {
			TrackPage TP = new TrackPage(driver);
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOf(TP.getSavedReports()));
			Thread.sleep(10000);

			TP.getSavedReports().click();
			Thread.sleep(10000);
			String title5 = driver.getTitle();
			String exp5 = "Saved Reports - MarkITplace";
			Thread.sleep(5000);
			Assert.assertEquals(title5, exp5);
		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Parameters({ "url" })
	@Test(priority = 30, enabled = false)
	public void ValidateComparePage(String url) throws InterruptedException {

		WebDriverWait wt = new WebDriverWait(driver, 20);
		SearchResultPage srp = new SearchResultPage(driver);
		HomePage hp = new HomePage(driver);
		String Exp = "Product Compare - MarkITplace";
		String act = null;
		try {
			hp.getsearchbox().sendKeys("printers" + Keys.ENTER);

			Thread.sleep(10000);

			WebElement web = driver.findElement(By.cssSelector(
					"section.product-list.container.clearfix:nth-child(5) div.product-list-content div.product-list-grid.clearfix.print-product-list.pro-list.grid:nth-child(2) div.product-grid-item.clearfix:nth-child(5) div.product-grid-item-content.clearfix div.list-item-right div.availability.clearfix span.stock.in-stock > span:nth-child(1)"));

			Actions actions = new Actions(driver);
			actions.moveToElement(web);
			actions.perform();

			srp.getCompare1().click();
			Thread.sleep(3000);
			srp.getCompare2().click();
			Thread.sleep(3000);
			srp.getCompareBtn().click();

			Thread.sleep(15000);

			Exp = "Product Compare - MarkITplace";
			act = driver.getTitle();
			Assert.assertEquals(act, Exp);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(hp.getacctmgmt());
			actions1.perform();

			Thread.sleep(10000);
			hp.logout().click();
			Thread.sleep(7000);
			driver.get(url);

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();

			Thread.sleep(10000);
			hp.logout().click();
			Thread.sleep(7000);
			driver.get(url);
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			e.printStackTrace();
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();

			Thread.sleep(10000);
			hp.logout().click();
			Thread.sleep(7000);
			driver.get(url);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();

			Thread.sleep(10000);
			hp.logout().click();
			Thread.sleep(7000);
			driver.get(url);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

}
