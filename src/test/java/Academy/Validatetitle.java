package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import resources.Base;

public class Validatetitle extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Validatetitle.class.getName());
	

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Qaclick academy");
	}

	@Test()
	public void basePageInitialize() throws IOException {

		Landingpage lp = new Landingpage(driver);
		// compare the text from browser with actual text - error
		Assert.assertEquals(lp.getCourses().getText(), "Featured Courses");
		log.info("Successfully validated text message");
		Assert.assertTrue(lp.getnav().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
