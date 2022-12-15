package excelRead_write;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		 {
			  File file=new File(System.getProperty("user.dir") + "\\TestData\\" + "RegressionTest_Data" + ".xlsx");
			  FileInputStream inputstream=new FileInputStream(file);
			  
			  XSSFWorkbook wb=new XSSFWorkbook(inputstream);
			  XSSFSheet sheet=wb.getSheet("LoginDetails");
			  XSSFRow row=sheet.getRow(1);
			  XSSFCell cell=row.getCell(0); 
			  
			  String username=cell.getStringCellValue();
			  System.out.println("User Name is : " + username );
			  
			  cell=row.getCell(1);
			  
			  String password=cell.getStringCellValue();
			  System.out.println("Password  is : " + password );
			  
			  

	}

}}
