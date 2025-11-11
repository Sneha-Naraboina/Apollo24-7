package com.parameters;

import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelWriter {
	public void createExcel() throws IOException{
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet1=workbook.createSheet("Number");
		sheet1.createRow(0).createCell(0).setCellValue("9491840330");
	
		
		XSSFSheet sheet2=workbook.createSheet("Invalid Search");
		sheet2.createRow(0).createCell(0).setCellValue("ushaysdbhdcbj");
		sheet2.createRow(1).createCell(0).setCellValue("hdgyffhfjfjn");
		sheet2.createRow(2).createCell(0).setCellValue("yehfhudjh");
		
		
		FileOutputStream fileOut = new FileOutputStream("src/test/resource/ExcelReader/Book3.xlsx");
		workbook.write(fileOut);
		workbook.close();
		fileOut.close();
	}
	
	public static void main(String[] args) throws IOException {
		ExcelWriter writer=new ExcelWriter();
		writer.createExcel();
	}
 
}
