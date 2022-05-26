package com.clearcapital;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.page.model.Frame;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clearcapital.utils.ReusableMethods;

public class Furniture {
	
	static String url = "https://www.ikea.com/us/en";
	static WebDriver driver = null;
	

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muham\\eclipse-workspace\\ClearCapital\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		ReusableMethods.searchBox(driver, "//input[@type='search']", "sofa");
		WebElement clickButton =  driver.findElement(By.xpath("//button[@id='search-box__searchbutton']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(clickButton));
		clickButton.click();
		ReusableMethods.selectFromSearchResult(driver, "//span[@class='pip-header-section__title--small notranslate']", 
				1, "//span[@class='pip-btn__label' and text()='Add to bag']");
		WebElement continueButton = driver.findElement(By.xpath("(//*[@href='https://www.ikea.com/us/en/shoppingcart/'])[2]"));
		continueButton.click();
		ReusableMethods.searchBox(driver, "//input[@type='search']", "table");
		
		driver.findElement(By.xpath("//button[@id='search-box__searchbutton']")).sendKeys(Keys.ENTER);
		
		ReusableMethods.selectFromSearchResult(driver, "(//div[@class='pip-compact-price-package'])", 
				3, "//button[@class='button__add-to-cart']");
		WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='hnf-btn__inner js-shopping-cart-icon']"));
		shoppingCart.click();
		String itemsInTheCart = driver.findElement(By.xpath("//span[@class='hnf-btn__inner js-shopping-cart-icon']")).getAttribute("data-count");
		System.out.println("Total items in the cart: "+itemsInTheCart != null ? itemsInTheCart : " Wrong amount" );
		
		}

	}
