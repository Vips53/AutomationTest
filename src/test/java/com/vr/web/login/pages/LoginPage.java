package com.vr.web.login.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.vr.constant.ProjectConstant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static WebDriver driver = null;

	ProjectConstant constant = new ProjectConstant();

	private By username = By.cssSelector("input#username");
	private By password = By.cssSelector("input#password");
	private By loginButton = By.cssSelector("button#submit");
	private By loginMsg = By.xpath("//h1[@class='post-']");
	private By loginMsg2 = By.xpath("//h1[@class='post-title']");

	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(constant.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void enterDetails() {
		enterTextInFiled(this.username, constant.username);
		enterTextInFiled(this.password, constant.password);
		clickOnELement(this.loginButton);
	}

	public String loginvalidation() {
		return getText();
	}
	
	//###############################Utils###################################
	
	public void clickOnELement(By locator) {
		driver.findElement(locator).click();
	}
	
	public void enterTextInFiled(By locator, String value) {
		driver.findElement(locator).sendKeys(value);	
	}
	
	public String getText() {
		try {
			return driver.findElement(this.loginMsg).getText();
		} catch (Exception e) {
			return driver.findElement(this.loginMsg2).getText();	
		}
		
	}
	
	

}
