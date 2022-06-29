package rpts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendRept 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		ExtentSparkReporter htmlreprot = new ExtentSparkReporter(new File("rept.html"));
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(htmlreprot);
		
		ExtentTest test1 = ext.createTest("Google Search", "Automation Google Search");
		
		String prjpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", prjpath + "/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Test case starting");
		
		driver.get("https://www.google.com");
		test1.pass("Application Launched Successfully");
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("extentReports");
		test1.pass("Entered text in search box");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Clicked Search button");
		
		driver.quit();
		test1.pass("Browser Closed");
		
		test1.info("Test Completed");
		ext.flush();
		
	}

}
