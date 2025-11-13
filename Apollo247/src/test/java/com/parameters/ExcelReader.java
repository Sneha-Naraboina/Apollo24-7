//package com.parameters;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//	 
//	public class ExcelReader {
//	 
//	    private Workbook workbook;
//	 
//	    public ExcelReader(String filePath) {
//	        try (FileInputStream fis = new FileInputStream(filePath)) {
//	            workbook = new XSSFWorkbook(fis);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	 
//	    // Get all data from the first sheet
//	    public List<List<String>> getAllData(int sheetIndex) {
//	        List<List<String>> data = new ArrayList<>();
//	        Sheet sheet = workbook.getSheetAt(sheetIndex);
//	 
//	        for (Row row : sheet) {
//	            List<String> rowData = new ArrayList<>();
//	            for (Cell cell : row) {
//	                rowData.add(cell.toString().trim());
//	            }
//	            data.add(rowData);
//	        }
//	        return data;
//	    }
//	 
//	    // Get a specific row's data
//	    public List<String> getRowData(int sheetIndex, int rowIndex) {
//	        List<String> rowData = new ArrayList<>();
//	        Sheet sheet = workbook.getSheetAt(sheetIndex);
//	        Row row = sheet.getRow(rowIndex);
//	 
//	        if (row != null) {
//	            for (Cell cell : row) {
//	                rowData.add(cell.toString().trim());
//	            }
//	        }
//	        return rowData;
//	    }
//	 
//	    public void close() {
//	        try {
//	            if (workbook != null) {
//	                workbook.close();
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
//================above soujanya
//package com.parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//
//    private Workbook workbook;
//
//    // ✅ Constructor that loads the Excel file
//    public ExcelReader(String excelPath) {
//        try {
//            FileInputStream fis = new FileInputStream(excelPath);
//            workbook = new XSSFWorkbook(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // ✅ Reads all rows and columns from the given sheet
//    public List<List<String>> getAllData(int sheetIndex) {
//        List<List<String>> data = new ArrayList<>();
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//
//        for (Row row : sheet) {
//            List<String> rowData = new ArrayList<>();
//            for (Cell cell : row) {
//                rowData.add(cell.toString().trim());
//            }
//            data.add(rowData);
//        }
//        return data;
//    }
//
//    // ✅ Optional: Read a specific row
//    public List<String> getRowData(int sheetIndex, int rowIndex) {
//        List<String> rowData = new ArrayList<>();
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowIndex);
//
//        if (row != null) {
//            for (Cell cell : row) {
//                rowData.add(cell.toString().trim());
//            }
//        }
//        return rowData;
//    }
//
//    //  Optional: Read a specific cell
//    public String getCellData(int sheetIndex, int rowIndex, int colIndex) {
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowIndex);
//        if (row != null) {
//            Cell cell = row.getCell(colIndex);
//            if (cell != null) {
//                return cell.toString().trim();
//            }
//        }
//        return "";
//    }
//
//    //  Close workbook after use
//    public void close() {
//        try {
//            if (workbook != null) {
//                workbook.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//	 
	
 

