package module.Pom.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin2Page {
	@FindBy(xpath="//input[@type='password']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	
	
	public KiteLogin2Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setKiteLogin2PagePin(String PIN)
	{
		pin.sendKeys(PIN);
	}

	public void clickKiteLogin2PageSubmitButton()
	{
		submit.click();
	}
}
