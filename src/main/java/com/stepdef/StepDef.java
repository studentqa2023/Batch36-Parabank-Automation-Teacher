package com.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.DriverManager;
import com.pagefactory.MasterPageFactory;
import com.utility.Highlighter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	MasterPageFactory mpf;
	@Given("open the browser")
	public void open_the_browser() {
	    
		DriverManager dm = new DriverManager();
		driver = dm.getFirefoxDriver(driver);
	}

	@Given("pass the URL {string}")
	public void pass_the_url(String URL) {
	    
	    driver.navigate().to(URL);
	}

	@When("enter username {string} in the Username field")
	public void enter_username_in_the_username_field(String username) {
	    
	    mpf = new MasterPageFactory(driver);
	    
	    Highlighter.addColor(driver, mpf.getUsername());
	    mpf.getUsername().sendKeys(username);
	}

	@When("enter password {string} in the Password field")
	public void enter_password_in_the_password_field(String password) {
	    
		Highlighter.addColor(driver, mpf.getPassword());
	    mpf.getPassword().sendKeys(password);
	}

	@When("click on Login")
	public void click_on_login() {
	    
		Highlighter.addColor(driver, mpf.getLoginbtn());
	    mpf.getLoginbtn().click();
	}

	@Then("validate login is successful")
	public void validate_login_is_successful() {
	    
	    Assert.assertTrue(mpf.getLogoutbtn().isDisplayed(), "Login successful");
	    
	    if(mpf.getLogoutbtn().isDisplayed()) {
	    	System.out.println("Login is successful!");
	    }else {
	    	System.out.println("Login not successful!");
	    }
	    
	    
	}
	
	@When("click on Log Out")
	public void click_on_log_out() {
	    
		Highlighter.addColor(driver, mpf.getLogoutbtn());
	    mpf.getLogoutbtn().click();
	}

	@Then("validate logout is successful")
	public void validate_logout_is_successful() {
	    
	    Assert.assertTrue(mpf.getLoginbtn().isDisplayed(), "Logout successful");
	    
	    if(mpf.getLoginbtn().isDisplayed()) {
	    	System.out.println("Logout is successful!");
	    }else {
	    	System.out.println("Logout is failed!");
	    }
	}

}
