package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	protected static WebDriver driver;
	//openDriver==openBrowser
	public static void openDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anuja damkondwar\\eclipse-workspace\\FrmaeworkPractice\\Browser\\chromedriver.exe\\" );
		driver=new ChromeDriver();
		driver.get("https://kite.zerodha.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
