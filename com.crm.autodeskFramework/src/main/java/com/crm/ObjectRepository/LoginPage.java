package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		//initialization of WebElement
		public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		//declaration of web element
		@FindBy(name="user_name")
		private WebElement userTextField;
		
		@FindBy(name="user_password")
		private WebElement passwordTextFeild;
		
		@FindBy(id="submitButton")
		private WebElement loginButton;

		
		//getters to use in test scripts
		public WebElement getUserTextField() {
			return userTextField;
		}

		public WebElement getPasswordTextFeild() {
			return passwordTextFeild;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		//Business logic for WebElements
		public void login(String username, String password) {
			userTextField.sendKeys(username);
			passwordTextFeild.sendKeys(password);
			loginButton.click();
		}
}
