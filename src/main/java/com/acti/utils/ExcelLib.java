package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	
XSSFWorkbook wb;
	
	public ExcelLib(String filepath)
	{
		try
		{
			File src = new File(filepath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public int getRowCount(int sheetno)
	{
		return wb.getSheetAt(sheetno).getLastRowNum() + 1;
	}
	public String getCellData(int sheetno,int row,int cell)
	{
		return wb.getSheetAt(sheetno).getRow(row).getCell(cell).toString();
		
	}

}
