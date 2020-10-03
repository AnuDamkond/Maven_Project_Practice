package module.Pom.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page {
	@FindBy(xpath="//input[@type='text']") private WebElement uname;
	@FindBy(xpath="//input[@type='password']") private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	
	public KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setKiteLogin1PageUsername(String Username)
	{
		uname.sendKeys(Username);
	}
	
	public void setKiteLogin1PagePassword(String Password)
	{
		pwd.sendKeys(Password);
	}
	
	public void clickKiteLogin1PageLoginButton()
	{
		loginButton.click();
	}
}
