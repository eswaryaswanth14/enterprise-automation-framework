package com.enterprise.automation.data;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import com.enterprise.automation.utils.ExcelDataReader;

public class ExcelLoginDataProvider {
	@DataProvider(name="excelLoginData")
	public Object[][] getLoginData() throws IOException{
		return ExcelDataReader.getExcelData();
	}
	
}
