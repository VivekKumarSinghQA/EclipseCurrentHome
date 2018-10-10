package com.Actions;

import com.PageObjects.LoginPageObjects;
import com.utilities.Environment;
import com.utilities.WebDriverUtils;

public class LoginActions {

	public static void LoginAction() throws Exception {

		WebDriverUtils.goToURL(Environment.ReadExcelData("URL", 1, 0));
		WebDriverUtils.InputValues(LoginPageObjects.UsernameField(), Environment.ReadExcelData("Credentials", 1, 0));
		WebDriverUtils.ClickAction(LoginPageObjects.NextButtonEmail());
		WebDriverUtils.InputValues(LoginPageObjects.PasswordField(), Environment.ReadExcelData("Credentials", 1, 1));
		WebDriverUtils.ClickAction(LoginPageObjects.SignInButton());
		WebDriverUtils.ClickAction(LoginPageObjects.YesButton());
		WebDriverUtils.ClickAction(LoginPageObjects.DoneButton());
	}
}