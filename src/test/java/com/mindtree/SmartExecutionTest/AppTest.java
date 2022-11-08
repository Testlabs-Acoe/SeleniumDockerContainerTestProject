package com.mindtree.SmartExecutionTest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

	public static RemoteWebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("print from before suit");
		Date currentDate = new Date();
		String reportFilename = currentDate.toString().replace(" ", "-").replace(":", "-");
//		extent = new ExtentReports(".//Reports//"+reportFilename+".html", true);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("print from before method");
//		test = extent.startTest((this.getClass().getSimpleName() + "::" + method.getName()), method.getName());
	}

	@BeforeTest
	public void setTest() throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.amazon.in/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		String Node = System.getProperty("remote_webdriver_url");
		System.out.println("this is webdriver url "+Node);
		driver = new RemoteWebDriver(new URL(Node), cap);
		
	}

	@Test
	public void login() {

		System.out.println("print from test");
		driver.get("https://www.mindtree.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.name("q")).sendKeys("mindtree");
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
//		WebElement element = driver.findElement(By.xpath("//a[@id = 'nav-link-accountList']"));
//		Actions action = new Actions(driver);
//		action.click(element).perform();
//		driver.findElement(By.xpath("//input[@id = 'ap_email']")).sendKeys("vaishalijindal99@gmail.com");
//		driver.findElement(By.xpath("//input[@id = 'continue']")).click();
//		driver.findElement(By.xpath("//input[@id = 'ap_password']")).sendKeys("Tomphiker@25");
//		test.log(LogStatus.PASS, "Entering the credentaial");
//		driver.findElement(By.xpath("//input[@id = 'signInSubmit']")).click();
//		test.log(LogStatus.PASS, "Logged in");
	}

	@AfterMethod
	public void afterMethod() {
//		extent.endTest(test);
	}

	@AfterTest
	public void downTest() {
		driver.close();
		driver.quit();
//		test.log(LogStatus.PASS, "quit the driver");
	}

	@AfterSuite
	public void afterSuite() {
//		extent.flush();
//		extent.close();
	}
}
