package framework.prerequisites;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureMultipleScreenshots {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		CaptureMultipleScreenshots.Capture(driver);
		driver.findElement(By.name("q")).sendKeys("Knowledge share");
		CaptureMultipleScreenshots.Capture(driver);	
	}
	
   public static void Capture(WebDriver driver ) throws IOException{
	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(src, new File("D:\\ScreenShot_Captured\\error.png" + System.currentTimeMillis() +"Screenshot.png")	);
	   
	   
   }	

}
