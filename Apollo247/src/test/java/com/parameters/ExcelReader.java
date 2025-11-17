package com.parameters;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    //private String excelPath;
    public XSSFWorkbook workbook;
    public String filePath ="C:\\Training\\JAVA\\Apollo 24by7\\Apollo247\\src\\test\\resources\\ExcelReader\\Exceldata1.xlsx";

//    public ExcelReader(String excelPath) {
//        this.excelPath = excelPath;
//    }

    // Initialize workbook
    public List<String> getRowData(int rowIndex, int sheetNo) throws Exception {
	    List<String> rowData = new ArrayList<>();
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheetAt(sheetNo);
	        Row row = sheet.getRow(rowIndex);
	        if (row != null) {
	            for (Cell cell : row) {
	                String value = cell.toString().trim();
	                if (!value.isEmpty()) {
	                    rowData.add(value);
	                }
	            }
	        }
	    }
	    return rowData;
}
}