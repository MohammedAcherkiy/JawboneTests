package newJawboneTest;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderFile {

	@DataProvider(name = "data")
	public static Object[][] DataTest(Method m) {
		Object[][] obj = null;
		if (m.getName().equals("SignUpAndCreatEAccount")) {

			obj = new Object[1][6];
			obj[0][0] = "FirstName";
			obj[0][1] = "LastName";
			obj[0][2] = "casablanca123@hotmail.com";
			obj[0][3] = "casablanca123@hotmail.com";
			obj[0][4] = "passWord";
			obj[0][5] = "passWord";

		}
		if (m.getName().equals("LogInWithValidCredential")) {

			obj = new Object[1][2];
			obj[0][0] = "casablanca123@hotmail.com";
			obj[0][1] = "passWord";

		}
		if (m.getName().equals("loginWithInvalidCredential")) {

			obj = new Object[1][2];
			obj[0][0] = "Fakeemail";
			obj[0][1] = "WrongPassWord";

		}
		return obj;

	}

}
