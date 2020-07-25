package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Validatetitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeDriver();
		log.info("Driver is initialized");
		
	}

	@Test(dataProvider = "getData")
	public void basePageInitialize(String Username, String Password) throws IOException {
		
		driver.get(prop.getProperty("url"));

		Landingpage lp = new Landingpage(driver);
		lp.getLogin().click();
		LoginPage lg = new LoginPage(driver);
		lg.getemail().sendKeys(Username);
		lg.getpassword().sendKeys(Password);
		lg.getlogin().click();
		log.info("login done");

	}

	@DataProvider
	public Object[][] getData() {
		// row stands for how many different data type should run
		// column stand how many values you are sending for each test
		Object[][] data = new Object[2][2];
		data[0][0] = "hgfhfhjg";
		data[0][1] = "hgfdhg";

		data[1][0] = "tutff";
		data[1][1] = "gfhj";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
