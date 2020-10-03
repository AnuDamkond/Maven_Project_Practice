package module.Pom.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	
	@FindBy(xpath="//div[@class='avatar']") private WebElement profileName;
	
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyKiteHomePageProfileName()
	{
		String actResult = profileName.getText();
		return actResult;
	}
}
