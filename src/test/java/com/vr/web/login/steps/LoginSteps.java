package com.vr.web.login.steps;

import org.testng.asserts.SoftAssert;

import com.vr.web.login.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	LoginPage lg = new LoginPage();
	SoftAssert soft = new SoftAssert();

	@Given("User need to launch the web application")
	public void user_need_to_launch_the_web_application() {
		lg.launchURL();
//		soft.assertEquals(false, false);
//		soft.assertAll();
	}

	@When("User need to enter the login username and password")
	public void user_need_to_enter_the_login_username_and_password() {
		lg.enterDetails();
//	   soft.assertEquals(false, false);
//		soft.assertAll();
	}

	@Then("User login successfully.")
	public void user_login_successfully() {
		soft.assertEquals(lg.loginvalidation(), "Logged In Successfully");
		soft.assertAll();
	}

}
