package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	By signin = By.linkText("Login");
	By featurecourses = By.xpath("//section[@id='content']/div/div/h2");
	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	
	
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getCourses()
	{
		return driver.findElement(featurecourses);
	}
	public WebElement getnav()
	{
		return driver.findElement(navbar);
	}

}
