package com.qa.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {
	
	WebDriver driver;
    String base_url = "https://amazon.in";
    int implicit_wait_timeout_in_sec = 30;
	
	 @Given("user opened browser")
	    public void user_opened_browser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
			
		 ChromeOptions opt = new ChromeOptions();
		 opt.setBinary("C:\\Users\\ADMIN\\eclipse-workspace\\chrome-win64\\chrome.exe");
			
	     driver = new ChromeDriver(opt);
//		 WebDriverManager.chromedriver().setup();
//		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	    }
	    
	    @Given("user navigated to the home application url")
	    public void user_navigated_to_the_home_application_url() {
	    	
	    	driver.get(base_url);
	    	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	    	String actualTitle = driver.getTitle();
	    	Assert.assertEquals("The title of the home page is not matched as expected",expectedTitle, actualTitle);
	       
	    }
	    
	    @When("user Search for product {string}")
	    public void user_search_for_product(String ProductName) {
	    	
	    	WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
	    	WebDriverWait wait = new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
	        
	        searchBox.sendKeys(ProductName);
	        
	        WebElement searchBtnEle = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
	        searchBtnEle.click();
	    }
	    
	    @Then("Search Result page is displayed with page title keyword contains {string}")
	    public void search_result_page_is_displayed_with_page_title_keyword_contains(String titleProdNameContains) {
	   
	    	String expectedTitle = "Amazon.in : " + titleProdNameContains;
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.titleContains(titleProdNameContains));
	        
	        Assert.assertEquals(expectedTitle, driver.getTitle());
	        
	        driver.quit();
	    }

}
