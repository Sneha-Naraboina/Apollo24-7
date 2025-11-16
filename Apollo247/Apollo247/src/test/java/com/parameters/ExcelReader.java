package com.parameters;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {
    public static Workbook workbook;

    public static void loadExcel(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        workbook = WorkbookFactory.create(fis);
    }

    public static String getCellData(String sheetName, int rowIndex, int colIndex) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        return cell.getStringCellValue();
    }
    

//   public static String getCellDataBySheetIndex(int sheetIndex, int rowIndex, int colIndex) {
//    Sheet sheet = workbook.getSheetAt(sheetIndex);
//    Row row = sheet.getRow(rowIndex);
//    Cell cell = row.getCell(colIndex);
//    return cell.getStringCellValue();
//    
//    }
    
    public static String getCellDataBySheetIndex(int sheetIndex, int rowIndex, int colIndex) 
    {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            throw new IllegalArgumentException("Row " + rowIndex + " does not exist in sheet " + sheetIndex);
        }
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            throw new IllegalArgumentException("Cell " + colIndex + " does not exist in row " + rowIndex);
        }

        // Handle numeric and string values
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // Convert to String
            default:
                throw new IllegalArgumentException("Unsupported cell type at row " + rowIndex);
        }
    
     }
    
    
}


























//code given by copilot
//package com.parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader 
//{
//public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
//    FileInputStream fileInputStream = new FileInputStream(filePath);
//    Workbook workbook = new XSSFWorkbook(fileInputStream);
//
//    Sheet sheet = workbook.getSheet(sheetName);
//    if (sheet == null) {
//        workbook.close();
//        fileInputStream.close();
//        throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file: " + filePath);
//    }
//
//    Row row = sheet.getRow(rowNum);
//    if (row == null) {
//        workbook.close();
//        fileInputStream.close();
//        throw new RuntimeException("Row " + rowNum + " not found in sheet '" + sheetName + "'.");
//    }
//
//    Cell cell = row.getCell(colNum);
//    if (cell == null) {
//        workbook.close();
//        fileInputStream.close();
//        throw new RuntimeException("Cell " + colNum + " not found in row " + rowNum + ".");
//    }
//
//    String value;
//    switch (cell.getCellType()) {
//        case STRING:
//            value = cell.getStringCellValue();
//            break;
//        case NUMERIC:
//            value = String.valueOf((long) cell.getNumericCellValue());
//            break;
//        case BOOLEAN:
//            value = String.valueOf(cell.getBooleanCellValue());
//            break;
//        default:
//            value = "";
//    }
//
//    workbook.close();
//    fileInputStream.close();
//    return value;
//}
//}

//teju given code
//package com.parameters;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    public static String getCellData(String filePath, int rowNum, int colNum) throws IOException {
//        
//    	File file = new File(filePath);
//    	FileInputStream file1 = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file1);
//        Sheet sheet = workbook.getSheet(filePath);
//        Row row = sheet.getRow(rowNum);
//        Cell cell = row.getCell(colNum);
//
//        String value;
//        switch (cell.getCellType()) {
//            case STRING:
//                value = cell.getStringCellValue();
//                break;
//            case NUMERIC:
//                value = String.valueOf((long) cell.getNumericCellValue());
//                break;
//            case BOOLEAN:
//                value = String.valueOf(cell.getBooleanCellValue());
//                break;
//            default:
//                value = "";
//        }
//
//        workbook.close();
//        file1.close();
//        return value;
//    }
//}


//public class ExcelReader {
//	public static String getCellData(String filePath, int sheetIndex, int rowNum, int colNum) throws IOException {
//        
//    	File file = new File(filePath);
//    	FileInputStream file1 = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file1);
//        //Sheet sheet = workbook.getSheet(filePath);
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowNum);
//        Cell cell = row.getCell(colNum);
//
//        String value;
//        switch (cell.getCellType()) {
//            case STRING:
//                value = cell.getStringCellValue();
//                break;
//            case NUMERIC:
//                value = String.valueOf((long) cell.getNumericCellValue());
//                break;
//            case BOOLEAN:
//                value = String.valueOf(cell.getBooleanCellValue());
//                break;
//            default:
//                value = "";
//        }
//
//        workbook.close();
//        file1.close();
//        return value;
//    }
//}




























//package com.parameters;
//
//public class ExcelReader 
//{
//	public static String getCellData(String sheetname,int rowNum, int colNum) throws IOException {
//		FileInputStream file = new FileInputStream("/Apollo247/src/test/resources/ExcelData/Phonenumber data.xlsx");
//		Workbook workbook = new XSSFWorkbook(file);
//		Sheet sheet = workbook.getSheet(sheetname);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.getCell(colNum);
//
//		String value;
//		switch(cell.getCellType()) {
//		case STRING:
//			value = cell.getStringCellValue();
//			break;
//		case NUMERIC:
//			value = String.valueOf((long) cell.getNumericCellValue());
//			break;
//		case BOOLEAN:
//			value = String.valueOf(cell.getBooleanCellValue());
//			break;
//			default:
//				value ="";
//		}
//		workbook.close();
//		file.close();
//		return value;
//
//
//	}
// 
// 
//	
//
//}



