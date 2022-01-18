package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Home.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class base {
		public static Logger Log = LogManager.getLogger(base.class.getName());
	public  static WebDriver driver;
	public static String url;
	public static Properties prop;
	public static FileInputStream fis;
	public LoginPage lp;
	
	
	public WebDriver initializeDriver() throws IOException
	{   
		

		 DesiredCapabilities dCaps;
		
	 
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		System.out.println("Browser selected is "+browserName);
		
		if(browserName.equals("phantom"))
		{
			
			
		    File file = new File("phantomjs.exe");				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			dCaps = new DesiredCapabilities();
			  dCaps.setJavascriptEnabled(true);
			  dCaps.setCapability("takesScreenshot", false);
			  
			  driver = new PhantomJSDriver(dCaps);
			 //driver = new ChromeDriver();
		}
		
		if(browserName.equals("chrome"))
		{
			
			ChromeOptions chromeOptions= new ChromeOptions();
		
			chromeOptions.setBinary("Application\\chrome.exe");
			//chromeOptions.setBinary("chrome.exe");

		   
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
			
			 driver = new ChromeDriver(chromeOptions);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equals("edge"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		

		return driver;
	}
	

	public static WebDriver getdriver()
	{
		if (driver == null){
			return driver;
			}else{
			return driver;
			}
	}
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Automation-Snapshots\\"+result+" screenshot.png"));
	}

}
