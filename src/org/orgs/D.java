package org.orgs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Durai\\eclipse-workspace\\InterviewwQ\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		WebElement closeBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closeBtn.click();
		WebElement searchTxtBar = driver.findElement(By.className("_3704LK"));
		searchTxtBar.sendKeys("iPhone");
		WebElement searchBarBtn = driver.findElement(By.className("L0Z3Pu"));
		searchBarBtn.click();

		Thread.sleep(3000);
		driver.quit();

	}

}
