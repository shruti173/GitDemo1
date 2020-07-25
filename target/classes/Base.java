package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initalizeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ak\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ak\\Desktop\\chromedriver.exe");
			 driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ak\\Desktop\\geckodriver.exe");
			 driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\ak\\Desktop\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		TakesScreenshot ts=(TakesScreenshot) driver;

		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
