package com.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class xlsutils {

	static Workbook book;
	static Sheet sheet;

	public static String TestData = System.getProperty("user.dir")+"\\src\\main\\java\\com\\hubspot\\testdata\\TestData.xlsx";

	public static Object[][] getData(String sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(TestData);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}

		}
		return data;
	}
}
