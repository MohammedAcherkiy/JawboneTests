package newJawboneTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	public void fillInFirstName(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-first-name"), s);

	}

	public void fillinLastName(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-last-name"), s);

	}

	public void fillInEmail(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-email"), s);

	}

	public void confirmEmail(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-confirm-email"), s);

	}

	public void fillInPassWord(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-password"), s);

	}

	public void ConfirmPassWord(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("new-account-confirm-password"), s);

	}

	public void checkButton(WebDriver driver) {
		WebUtil.click(driver, By.id("accept-terms"));

	}

	public void continueButton(WebDriver driver) {
		WebUtil.click(driver, By.id("jawbone-create-account-button"));

		WebUtil.waitForElementVisible(driver, By.xpath("//*[@class='user-info jb-responsive-hover']"));

	}

	public void signout(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//*[@class='user-info jb-responsive-hover']"));

	}

	public SignInPage signOut2(WebDriver driver) {
		WebUtil.click(driver, By.linkText("Sign Out"));

		// wait for the homepage
		WebUtil.waitForElementVisible(driver, (By.id("jawbone-login-trigger")));

		return PageFactory.initElements(driver, SignInPage.class);
	}

}
