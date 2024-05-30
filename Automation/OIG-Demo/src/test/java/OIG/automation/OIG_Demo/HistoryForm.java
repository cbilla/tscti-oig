package OIG.automation.OIG_Demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class HistoryForm {
	private WebDriver driver;
	JavascriptExecutor js;
	public void sleepThread() throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp() throws TransformerException, InterruptedException {
		//String filepath = new java.io.File("").getAbsolutePath() + "/src/resource/chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", filepath);
		ChromeOptions options = new ChromeOptions();
	    //options.addArguments("--remote-allow-origins=*");
	  //  options.addArguments("--whitelisted-ips=''");
		//options.setExperimentalOption("useAutomationExtension", false);
		ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                 options.addArguments("--headless");
	        driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;	
		driver.get("http://54.227.107.51:3000/");
		sleepThread();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin@123");
	    
	try {
	  Thread.sleep(5000);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}

	driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	
	
	}

	@AfterMethod
	public void tearDown() {

		try {
			driver.quit();
		} catch (Exception e) {

		}
	}

	@Test
	public void assetsLiabiltyTest() throws Exception {
		driver.findElement(By.xpath("//div[contains(text(),'Add Identity History Summary')]")).click();	

		
	    driver.findElement(By.id("last_name")).sendKeys("lstname");
	    sleepThread();
	    driver.findElement(By.id("first_name")).sendKeys("frstname");
	    sleepThread();
	    driver.findElement(By.id("dob")).sendKeys("2000-08-08");
	   
	    driver.findElement(By.id("place_of_birth")).sendKeys("mclean");
	    driver.findElement(By.xpath("//*[text() = \"Yes\"]")).click();
	    sleepThread();
	    driver.findElement(By.id("country_of_citizenship")).sendKeys("usa");
	    
	    driver.findElement(By.id("ssn_last_four")).sendKeys("1234");
	    driver.findElement(By.xpath("//*[text() = \"Unknown\"]")).click();
	    driver.findElement(By.xpath("//*[text() = \"Male\"]")).click();
	   
	    driver.findElement(By.id("address")).sendKeys("1234 greensboro");
	    sleepThread();
	    driver.findElement(By.id("city")).sendKeys("mclean");
	   
	    driver.findElement(By.id("state")).sendKeys("virginia");
	  
	    driver.findElement(By.id("zip_code")).sendKeys("12345");
	  
	    driver.findElement(By.id("country")).sendKeys("usa");
	    sleepThread();
	    driver.findElement(By.xpath("//*[text() = \"Save\"]")).click();
	    sleepThread();
	    driver.findElement(By.cssSelector("svg.usa-icon.usa-icon--size-3")).click(); 
	}

	
}
