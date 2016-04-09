package com.wso2telco.test.framework.tools.excelfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWriter {
	
	private static XSSFWorkbook workbook = null;

	private static XSSFSheet sheet = null;
	
	private static XSSFRow row = null;

	private static XSSFCell cell = null;
	
	public void writeFileUsingArray(String fileName, List<List<String>> array){
		try {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Sheet1");
			int rowCount = array.size();
			int columnCount = array.get(0).size();
			for (int i = 0; i < rowCount; i++) {
				row = sheet.createRow((short) 0 + i);
				for (int k = 0; k < columnCount; k++) {
					cell = row.createCell((short) k);
					cell.setCellValue(array.get(i).get(k));
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
