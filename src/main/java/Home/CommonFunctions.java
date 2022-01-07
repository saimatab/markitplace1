package Home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions {

	public WebDriver driver;
	WebDriverWait wait;

	public CommonFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void gotoURL() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.navigate().to(url);
		wait.until(ExpectedConditions.titleContains("Login - MarkITplace"));
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Login - MarkITplace",
				"User is not being able to Login the application");

	}

	public void gotoURL(String url) throws IOException, InterruptedException {

		driver.navigate().to(url);

	}

	public void loginapp(String propUN, String propPwd) throws IOException, InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));

			lp.getusername().sendKeys(propUN);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getpassword()));
			lp.getpassword().sendKeys(propPwd);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getloginbtn()));
			lp.getloginbtn().click();
			Thread.sleep(5000);
			// Assert.assertEquals(driver.getTitle(), "Shop - MarkITplace", "User is not
			// being able to SignIn on application");
		} catch (org.openqa.selenium.NoSuchElementException e) {

			// WebElement
			// pw=driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn
			// btn-default'][contains(text(),'Close')]"));
			// pw.click();
			// Thread.sleep(3000);
			// driver.navigate().back();
			// wait.until(ExpectedConditions.titleContains("Order Confirmation -
			// MarkITplace"));
			// Assert.assertEquals(driver.getTitle(), "Order Confirmation - MarkITplace");
			Thread.sleep(5000);
			e.printStackTrace();

		}

	}

	public void logout() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		wait = new WebDriverWait(driver, 120);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
		Actions actions = new Actions(driver);
		actions.moveToElement(hp.getacctmgmt());
		actions.perform();
		// Thread.sleep(20000);
		wait.until(ExpectedConditions.elementToBeClickable(hp.logout()));
		Thread.sleep(10000);
		hp.logout().click();
		Thread.sleep(7000);
	}

}
