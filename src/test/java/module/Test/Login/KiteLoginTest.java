package module.Test.Login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.BaseClass;
import Library.Utility;
import module.Pom.Login.KiteHomePage;
import module.Pom.Login.KiteLogin1Page;
import module.Pom.Login.KiteLogin2Page;

public class KiteLoginTest extends BaseClass{
//	WebDriver driver;
	//Hello chnaged in exixting file
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;

	
	@BeforeClass
	public void openingBrowser()
	{
		Reporter.log("open browser", true);
		openDriver();
		login1=new KiteLogin1Page(driver);
		login2=new KiteLogin2Page(driver);
		home=new KiteHomePage(driver);
		
	}
	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException
	{
		Reporter.log("login to app", true);
		String UN = Utility.getDataFromPropertyFile("Uname");
		login1.setKiteLogin1PageUsername(UN);
		
		
		String PWD = Utility.getDataFromPropertyFile("Pwd");
		login1.setKiteLogin1PagePassword(PWD);
		
		login1.clickKiteLogin1PageLoginButton();
		Thread.sleep(3000);
		
		String PIN=Utility.getDataFromPropertyFile("Pin");
		login2.setKiteLogin2PagePin(PIN);
		
		login2.clickKiteLogin2PageSubmitButton();
	}
	@Test
	public void verifyProfileName() throws EncryptedDocumentException, IOException, InterruptedException
	{
	Reporter.log("verify profile name", true);
	String exp = Utility.getTestData(0, 3);
//	String exp="KV1";
	String act = home.verifyKiteHomePageProfileName();
	Assert.assertEquals(act, exp,"act & exp not matched");
	Thread.sleep(3000);

	}
	@AfterMethod
	public void logoutFromApp(ITestResult res) throws IOException, InterruptedException
	{
		if(res.getStatus()==ITestResult.FAILURE)
		{
			Utility.capturedScreenshot(driver);
		}
		Reporter.log("logout from app", true);
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	

}
