package excelRead_write;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelData_Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File(System.getProperty("user.dir") + "\\TestData\\" + "RegressionTest_Data" + ".xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("LoginDetails");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://183.82.103.245/nareshit/login.php");
		
		XSSFRow row = null;
		XSSFCell cell = null;
		String userName = null;
		String password = null;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (j == 0){
					userName = cell.getStringCellValue();
				}
				if (j == 1)	{
					password = cell.getStringCellValue();
				}
			}
			driver.findElement(By.name("txtUserName")).sendKeys(userName);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();

			String result = null;
			try {
				Boolean isLoggedIn = driver.findElement(By.linkText("Logout")).isDisplayed();
				if (isLoggedIn == true) {
					result = "PASS";
				}
				System.out.println("User Name : " + userName + " ----  " + "Password : " + password
						+ "----- Login success ? ------ " + result);
				Thread.sleep(3000);
				driver.findElement(By.linkText("Logout")).click();
		        
	
			} catch (Exception e) {
				Boolean isError = driver.findElement(By.xpath("//input[@text='Invalid Login']")).isDisplayed();
				if (isError == true) {
					result = "FAIL";
				}
				
			}
			
		}
		
	}

}
