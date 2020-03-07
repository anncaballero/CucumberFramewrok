package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static Workbook wbook;
	private static Sheet sheet;
	
	/**
	 * 
	 * @param filePath
	 */
	
	public static void openExcel(String filePath, String sheetName) {
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			wbook=new XSSFWorkbook(fis);
			sheet=wbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return number of rows
	 * @return
	 */

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	/**
	 * This method will return number of cols
	 * 
	 * @return
	 */
	public static int colsCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	/**
	 * This method will return data from specified row and column
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	
	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	
	public static Object[][] excelntoArray(String filePath, String sheetName){
		
		openExcel(filePath, sheetName);
		
		Object[][] data=new Object[rowCount()-1][colsCount()];
		
		for(int i=1; i<rowCount(); i++) {
			for(int y=0; y<colsCount();y++) {
				data[i-1][y]=getCellData(i, y);
			}
		}
		
		return data;
	}
	
}
