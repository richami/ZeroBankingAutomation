package com.bank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static String getData(String Sheetname, int row, int column) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\ZeroBankingLogin.xlsx";
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet(Sheetname);
		XSSFRow r= sheet.getRow(row);
		XSSFCell c= r.getCell(column);
		String data=c.getStringCellValue();
		return data;
	}

}
