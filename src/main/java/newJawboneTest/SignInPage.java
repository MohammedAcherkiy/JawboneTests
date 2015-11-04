package newJawboneTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	public void signIn(WebDriver driver) {
		WebUtil.click(driver, By.id("jawbone-login-trigger"));

		// Wait for the passWord link to be visible
		WebUtil.waitForElementVisible(driver, By.id("jawbone-login-forgot-password"));

	}

	// fill in email
	public void fillInInvalidEmail(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("jawbone-login-email"), s);

	}

	// fill in password
	public void fillInPassWord(WebDriver driver, String s) {

		WebUtil.clearAndSendKeys(driver, By.id("jawbone-login-pass"), s);
	}

	public void clickSignInButton(WebDriver driver) {
		WebUtil.click(driver, By.id("jawbone-login-form-button"));

		// Wait for the error message to be visible
		// WebUtil.waitForElementVisible(driver,
		// By.cssSelector("#client-login-errors>ol>li"));
	}

	public CreateAccountPage signUp(WebDriver driver) {
		WebUtil.click(driver, By.id("jawbone-myjawbone-signin"));
		// Wait for Create an account message to be displayed
		WebUtil.waitForElementVisible(driver, By.cssSelector("#jawbone-create-account-wrapper>h1"));

		return PageFactory.initElements(driver, CreateAccountPage.class);
	}

}
