package org.run;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;





public class Sample {
	
	public static WebDriver driver;
	
	
	public static void screens(String name) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		
		File ss = new File("C:\\Users\\raj\\eclipse-workspace\\Selenium\\Screenshot\\"+ name + ".png");
		
		FileUtils.copyFile(screenshotAs, ss);
				

	}

public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\raj\\eclipse-workspace\\Selenium\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println(currentUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		FluentWait<WebDriver> win = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(300)).ignoring(Throwable.class);
		
		
		
		
		WebElement drop = driver.findElement(By.xpath("//*[@title='Search in']"));
		
		drop.click();
		
		Select sele = new Select(drop);
		List<WebElement> options = sele.getOptions();
		
		for (WebElement webElement : options) {
			
			String text = webElement.getText();
			
			System.out.println(text);
			
			
		
			
			
		}
		
	
		
		
		
		
	}

}
