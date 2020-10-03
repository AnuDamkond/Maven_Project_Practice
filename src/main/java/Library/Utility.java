package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
//	public static String getTestData(int row, int cell) throws EncryptedDocumentException, IOException
//	{
//		FileInputStream fis = new FileInputStream("C:\\Users\\Anuja damkondwar\\eclipse-workspace\\Maven_Project_Practice\\TestData\\KiteTestData1.xlsx\\");
//		Workbook wb = WorkbookFactory.create(fis);
////		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
//		Sheet sheet = wb.getSheet("Sheet1");
//		String result = sheet.getRow(row).getCell(cell).getStringCellValue();
//		return result;
//	}
	
	public static String getTestData(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Anuja damkondwar\\eclipse-workspace\\Maven_Project_Practice\\TestData\\kitetestdata.xlsx\\");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	public static void capturedScreenshot(WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Anuja damkondwar\\eclipse-workspace\\Maven_Project_Practice\\Screenshot\\img1.jpg");
		FileHandler.copy(src, dest);
	}

	public static String getDataFromPropertyFile(String key) throws IOException {
		Properties obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\PropertyFile.properties");

		obj.load(objfile);
		
		String value = obj.getProperty(key);

		return value;
	}
}
