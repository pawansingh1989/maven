package com.company.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;




public class Excel 
{
	public FileInputStream file;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFCell cell;
	public DataFormatter formatter;
	
	
	public void setExcel(String path,String sheetname) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new HSSFWorkbook(file);
		sheet=workbook.getSheet(sheetname);
		
	}
	
	public String getCellValue(int row,int col)
	{
		{
		cell=sheet.getRow(row).getCell(col);
		formatter=new DataFormatter();
		return formatter.formatCellValue(cell);
		
		}
		
	}

}
