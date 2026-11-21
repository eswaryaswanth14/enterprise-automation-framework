package com.enterprise.automation.utils;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {


	public static Object[][] getExcelData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/main/resources/testdata/LoginTestData_Corrected.xlsx";
		try (FileInputStream f=new FileInputStream(path);
			XSSFWorkbook workBook=new XSSFWorkbook(f)){
			XSSFSheet sheet=workBook.getSheet("LoginData");
			if (sheet == null) {
			    throw new IllegalArgumentException("LoginData sheet not found");
			}
			int rowCount=sheet.getLastRowNum();
			int colCount=sheet.getRow(0).getLastCellNum();
			Object[][] data=new Object[rowCount][colCount];
			for(int i=1;i<=rowCount;i++) {
				XSSFRow currentRow=sheet.getRow(i);
				for(int j=0;j<colCount;j++) {
					XSSFCell currentCell=currentRow.getCell(j);
					data[i-1][j]=(currentCell==null)?"":currentCell.getStringCellValue();
				}
			}
			return data;

		}






	}

}
