package com.PageObjects;

import org.openqa.selenium.WebElement;

import com.utilities.WebDriverUtils;

public class LoginPageObjects {
	public static WebElement UsernameField() {
		return WebDriverUtils.FindElementByID("i0116");
	}

	public static WebElement PasswordField() {
		return WebDriverUtils.FindElementByID("i0118");
	}

	public static WebElement SignInButton() {
		return WebDriverUtils.FindElementByCSS("#idSIButton9");
	}

	public static WebElement YesButton() {
		return WebDriverUtils.FindElementByCSS("#idSIButton9");
	}

	public static WebElement DoneButton() {
		return WebDriverUtils.FindElementByCSS("section.form__group.-button.\\2b textCenter > button");
	}

	public static WebElement WelcomeText() {
		return WebDriverUtils.FindElementByCSS(".jumbotron.text-center>h1>span");
	}
	
	public static WebElement NextButtonEmail()
    {
        return WebDriverUtils.FindElementByID("idSIButton9");
    }
}
