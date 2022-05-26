package com.clearcapital.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
	
	
	
	
	public static void searchBox(WebDriver driver, String webElement, String targetItem) {
		
		WebElement searchBar = driver.findElement(By.xpath(webElement));
		searchBar.sendKeys(targetItem);
	}
	
	public static void selectFromSearchResult(WebDriver driver, String webElement, int elementIndex, String addToCartButton) {
		
		driver.findElement(By.xpath((webElement)+"["+elementIndex+"]")).click();
		driver.findElement(By.xpath(addToCartButton)).click();
	}

}
