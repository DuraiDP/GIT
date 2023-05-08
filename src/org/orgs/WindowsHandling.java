package org.orgs;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandling {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Durai\\eclipse-workspace\\InterviewwQ\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		Thread.sleep(5000);
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='cee_closeBtn']/img")).click();
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent Window ID:" + parentWindowId);
		driver.findElement(By.id("loginsubmit")).click();
		Set<String> allWindowId = driver.getWindowHandles();
		for (String x : allWindowId) {
			if (!parentWindowId.equals(x)) {
				System.out.println("Child Window ID:" + x);
				driver.switchTo().window(x);
				Thread.sleep(3000);
				driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a")).click();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
			}
		}
		Thread.sleep(3000);
		driver.quit();

	}

}


