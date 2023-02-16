package com.swaglabs.tests;

import org.openqa.selenium.By;

//SauceDemoTests.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemoTests {
 private WebDriver driver;

 @BeforeClass
 public void setUp() {
     System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.saucedemo.com/");
 }

 @AfterClass
 public void tearDown() {
     driver.quit();
 }

 @Test
 public void testValidLogin() throws InterruptedException {
     try {
		LoginPage loginPage = new LoginPage(driver);
		 loginPage.enterUsername("standard_user");
		 loginPage.enterPassword("secret_sauce");
		 loginPage.clickLoginButton();

		 // Assert that the user has successfully logged in
		 Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	} catch (Exception e) {
		 Thread.currentThread().interrupt();
	        System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
 } 

 @Test(dependsOnMethods = {"testValidLogin"})
 public void testLogout() throws InterruptedException{
     try {
		// Logout from the application
		 driver.findElement(By.id("logout_sidebar_link")).click();

		 // Assert that the user has been logged out and is back on the login page
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
 	} catch (Exception e) {
		 Thread.currentThread().interrupt();
	        System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
 }

 @Test
 public void testInvalidLogin()throws InterruptedException {
     try {
		LoginPage loginPage = new LoginPage(driver);
		 loginPage.enterUsername("invalid_user");
		 loginPage.enterPassword("invalid_password");
		 loginPage.clickLoginButton();

		 // Assert that the user is not logged in and an error message is displayed
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		 Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
 	} catch (Exception e) {
		 Thread.currentThread().interrupt();
	        System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
 }
}
