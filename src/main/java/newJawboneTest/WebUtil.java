package newJawboneTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {
	final static int WAIT_TIME_OUT = 30;

	public static SignInPage goToSignInPage(WebDriver driver) {

		driver.get("http://www.jawbone.com");

		return PageFactory.initElements(driver, SignInPage.class);
	}

	public static void clearAndSendKeys(WebDriver driver, By by, String s) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(s);

	}

	public static void click(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();

	}

	public static void waitForElementVisible(WebDriver driver, By by) {

		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

}
