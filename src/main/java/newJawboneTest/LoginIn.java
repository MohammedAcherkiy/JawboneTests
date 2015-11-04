package newJawboneTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginIn {
	WebDriver driver;
	SignInPage signInPage;

	@BeforeMethod
	public void SetUp() {
		driver = new FirefoxDriver();
		signInPage = WebUtil.goToSignInPage(driver);

	}

	@Test(dataProviderClass = DataProviderFile.class, dataProvider = "data", priority = 1)
	public void loginWithInvalidCredential(String email, String passWord) {

		// Click SignInButton in the homePage
		signInPage.signIn(driver);

		// Assert that the forgot password link is visible
		Assert.assertTrue(driver.findElement(By.id("jawbone-login-forgot-password")).isDisplayed());
		// Enter invalid email
		signInPage.fillInInvalidEmail(driver, email);

		// Enter invalid password
		signInPage.fillInPassWord(driver, passWord);

		// Click signIn Button
		signInPage.clickSignInButton(driver);

		// Assert that the error message is visible
		Assert.assertTrue(driver.findElement(By.cssSelector("#client-login-errors>ol>li")).isDisplayed());

	}

	@Test(dataProviderClass = DataProviderFile.class, dataProvider = "data", priority = 2)
	public void SignUpAndCreatEAccount(String firstName, String lastName, String email, String confirmEmail,
			String passWord, String confirmPassword) {

		// Click SignInButton in the homePage
		signInPage.signIn(driver);

		// Assert that the forgot password link is visible
		Assert.assertTrue(driver.findElement(By.id("jawbone-login-forgot-password")).isDisplayed());

		// Click signUp Button
		CreateAccountPage createAccountPage = signInPage.signUp(driver);

		// Assert that we are in create a new account page.
		Assert.assertTrue(driver.findElement(By.cssSelector("#jawbone-create-account-wrapper>h1")).isDisplayed());

		// Enter FirstName
		createAccountPage.fillInFirstName(driver, firstName);

		// Enter lastName
		createAccountPage.fillinLastName(driver, lastName);

		// Enter an email
		createAccountPage.fillInEmail(driver, email);

		// Confirm email
		createAccountPage.confirmEmail(driver, confirmEmail);

		// Enter passWord
		createAccountPage.fillInPassWord(driver, passWord);

		// Confirm passWord
		createAccountPage.ConfirmPassWord(driver, confirmPassword);

		// Check the Aknowledge Button
		createAccountPage.checkButton(driver);

		// Click Continue
		createAccountPage.continueButton(driver);

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='user-info jb-responsive-hover']")).isDisplayed());

		// SignOut
		createAccountPage.signout(driver);

		signInPage = createAccountPage.signOut2(driver);

		// Assert that user signed out successfully
		Assert.assertTrue(driver.findElement(By.id("jawbone-login-trigger")).isDisplayed());

	}

	@Test(dataProviderClass = DataProviderFile.class, dataProvider = "data", priority = 3)
	public void LogInWithValidCredential(String email, String passWord) {

		signInPage.signIn(driver);

		// Assert that the forgot password link is visible
		Assert.assertTrue(driver.findElement(By.id("jawbone-login-forgot-password")).isDisplayed());
		// Enter invalid email
		signInPage.fillInInvalidEmail(driver, email);

		// Enter invalid password
		signInPage.fillInPassWord(driver, passWord);

		// Click signIn Button
		signInPage.clickSignInButton(driver);
		WebUtil.waitForElementVisible(driver, By.xpath("//*[@class='user-info jb-responsive-hover']"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='user-info jb-responsive-hover']")).isDisplayed());

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
