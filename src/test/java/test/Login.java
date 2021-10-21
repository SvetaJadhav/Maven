package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test(priority=5)
	public void negativeLogin () throws InterruptedException {
	WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
	driver.get("http://Magento.com");
	driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
	driver.findElement(By.id("email")).sendKeys("Svetajadhav@live.com");
	driver.findElement(By.name("login[password]")).sendKeys("welcome123");
	driver.findElement(By.id("send2")).click();
Thread.sleep(3000);
	String error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();	
	System.out.println(error);
	Assert.assertEquals(error, "Invalid login or password.");
	driver.quit();
	}
	
	@Test(priority = 10)
	public void positiveLogin() throws InterruptedException {//right credentials
	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://Magento.com");
		driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
		driver.findElement(By.id("email")).sendKeys("Svetajadhav@live.com");
		driver.findElement(By.name("login[password]")).sendKeys("welcome");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
		
		driver.quit();
}
}