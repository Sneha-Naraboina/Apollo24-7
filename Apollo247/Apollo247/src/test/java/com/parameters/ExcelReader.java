////package com.parameters;
////
////import java.io.FileInputStream;
////import java.util.ArrayList;
////import java.util.List;
////
////import org.apache.poi.ss.usermodel.Cell;
////import org.apache.poi.ss.usermodel.CellType;
////import org.apache.poi.ss.usermodel.Row;
////import org.apache.poi.ss.usermodel.Sheet;
////import org.apache.poi.ss.usermodel.Workbook;
////import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//////
//////public class ExcelReader {
//////
//////    public static List<Map<String, String>> getExcelData(String filePath, String sheetName) {
//////        List<Map<String, String>> data = new ArrayList<>();
//////        try (FileInputStream fis = new FileInputStream(filePath);
//////             Workbook workbook = new XSSFWorkbook(fis)) {
//////
//////            Sheet sheet = workbook.getSheet(sheetName);
//////            if (sheet == null) {
//////                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
//////            }
//////
//////            Row headerRow = sheet.getRow(0);
//////            if (headerRow == null) {
//////                throw new RuntimeException("Header row is missing in sheet: " + sheetName);
//////            }
//////
//////            int colCount = headerRow.getLastCellNum();
//////
//////            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//////                Row row = sheet.getRow(i);
//////                if (row == null) continue;
//////
//////                Map<String, String> rowData = new LinkedHashMap<>();
//////                for (int j = 0; j < colCount; j++) {
//////                    String header = headerRow.getCell(j).getStringCellValue().trim();
//////                    String value = (row.getCell(j) != null) ? row.getCell(j).toString().trim() : "";
//////                    rowData.put(header, value);
//////                }
//////                data.add(rowData);
//////            }
//////        } catch (Exception e) {
//////            e.printStackTrace();
//////        }
//////        return data;
//////    }
//////}
////
////
////
////public class ExcelReader {
////    public static List<String[]> readExcel(String filePath) {
////        List<String[]> data = new ArrayList<>();
////        try (FileInputStream fis = new FileInputStream(filePath);
////             Workbook workbook = new XSSFWorkbook(fis)) {
////            Sheet sheet = workbook.getSheetAt(0);
////            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
////                Row row = sheet.getRow(i);
////                if (row == null) continue;
////                String[] rowData = new String[row.getLastCellNum()];
////                for (int j = 0; j < row.getLastCellNum(); j++) {
////                    Cell cell = row.getCell(j);
////                    if (cell == null) {
////                        rowData[j] = "";
////                    } else if (cell.getCellType() == CellType.NUMERIC) {
////                        rowData[j] = String.valueOf((long) cell.getNumericCellValue());
////                    } else {
////                        rowData[j] = cell.getStringCellValue();
////                    }
////                }
////                data.add(rowData);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return data;
////    }
////} 
//
//
////package com.parameters;
////
////import java.io.FileInputStream;
////import java.io.IOException;
////import org.apache.poi.ss.usermodel.*;
////import org.apache.poi.xssf.usermodel.XSSFWorkbook;
////
////public class ExcelReader {
////
////    private static final String FILE_PATH = PropertyReader.getProperty("excelPath");
////
////        public static String getCellData(int sheetIndex, int rowNum, int colNum) throws IOException {
////            FileInputStream file = new FileInputStream(FILE_PATH);
////            Workbook workbook = new XSSFWorkbook(file);
////            Sheet sheet = workbook.getSheetAt(sheetIndex);
////            Row row = sheet.getRow(rowNum);
////            Cell cell = row.getCell(colNum);
////
////            String value;
////            switch (cell.getCellType()) {
////                case STRING:
////                    value = cell.getStringCellValue();
////                    break;
////                case NUMERIC:
////                    value = String.valueOf((long) cell.getNumericCellValue());
////                    break;
////                case BOOLEAN:
////                    value = String.valueOf(cell.getBooleanCellValue());
////                    break;
////                default:
////                    value = "";
////            }
////
////            workbook.close();
////            file.close();
////            return value.trim();
////        }
////    }
//
//
//package com.Parameters;
// 
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// 
//public class ExcelReader {
//	
//	public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
//	    String filePath = "src/test/resources/ExcelData/SortOptions.xlsx";
//	    FileInputStream file = new FileInputStream(filePath);
//	    Workbook workbook = new XSSFWorkbook(file);
//	    Sheet sheet = workbook.getSheetAt(sheetNo);
//	    DataFormatter formatter = new DataFormatter();
// 
//	    // Get header row to determine column count
//	    Row headerRow = sheet.getRow(0);
//	    int colCount = headerRow.getLastCellNum();
// 
//	    // Read target row
//	    Row row = sheet.getRow(rowNum);
//	    String[] rowData = new String[colCount];
//	    for (int j = 0; j < colCount; j++) {
//	        Cell cell = (row != null) ? row.getCell(j) : null;
//	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
//	    }
// 
//	    workbook.close();
//	    file.close();
//	    return rowData;
//	}
//
//	public static String getCellData(int sheetNo, int rowNum, int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}
// 
//	
//}
package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String FILE_PATH = "src/test/resources/ExcelData/SortOptions.xlsx";

    // ✅ Get entire row as String[]
    public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        DataFormatter formatter = new DataFormatter();

        Row row = sheet.getRow(rowNum);
        int colCount = row.getLastCellNum();
        String[] rowData = new String[colCount];

        for (int j = 0; j < colCount; j++) {
            Cell cell = row.getCell(j);
            rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
        }

        workbook.close();
        file.close();
        return rowData;
    }

    // ✅ Get single cell value
    public static String getCellData(int sheetNo, int rowNum, int colNum) throws IOException {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String value = (cell != null) ? formatter.formatCellValue(cell) : "";

        workbook.close();
        file.close();
        return value.trim();
    }
}