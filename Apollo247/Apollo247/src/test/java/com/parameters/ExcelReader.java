package com.parameters;
 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
	public static String[] getRowData(int sheet, int row) throws IOException {
	    String filePath = "src/test/resources/ExcelData/SortBy.xlsx";
	    FileInputStream file = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(file);
	    Sheet sheetNo = workbook.getSheetAt(sheet);
	    DataFormatter formatter = new DataFormatter();
 
	    // Get header row to determine column count
	    Row headerRow = sheetNo.getRow(0);
	    int colCount = headerRow.getLastCellNum();
 
	    // Read target row
	    Row rowNo = sheetNo.getRow(row);
	    String[] rowData = new String[colCount];
	    for (int j = 0; j < colCount; j++) {
	        Cell cell = (rowNo != null) ? rowNo.getCell(j) : null;
	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
	    }
 
	    workbook.close();
	    file.close();
	    return rowData;
	}
	
 
	
}























//
//package com.parameters;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExcelReader {
//
//    private static final String FILE_PATH = "src/test/resources/ExcelData/SortOptions.xlsx";
//
//    // ✅ Get entire row as Map<Header, Value>
//    public static Map<String, String> getRowData(String sheetName, int rowNum) {
//        Map<String, String> data = new HashMap<>();
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            if (sheet == null) {
//                throw new RuntimeException("Sheet " + sheetName + " not found in Excel file");
//            }
//
//            Row headerRow = sheet.getRow(0);
//            Row dataRow = sheet.getRow(rowNum);
//            if (headerRow == null || dataRow == null) {
//                throw new RuntimeException("Invalid row index: " + rowNum);
//            }
//
//            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//                Cell headerCell = headerRow.getCell(i);
//                Cell valueCell = dataRow.getCell(i);
//                if (headerCell != null) {
//                    String key = headerCell.getStringCellValue().trim();
//                    String value = getCellValue(valueCell);
//                    data.put(key, value);
//                }
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error reading Excel: " + e.getMessage());
//        }
//        return data;
//    }
//
//    // ✅ Helper to handle different cell types
//    private static String getCellValue(Cell cell) {
//        if (cell == null) return "";
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue().trim();
//            case NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    return cell.getDateCellValue().toString();
//                } else {
//                    double numericValue = cell.getNumericCellValue();
//                    if (numericValue == Math.floor(numericValue)) {
//                        return String.valueOf((long) numericValue);
//                    } else {
//                        return String.valueOf(numericValue);
//                    }
//                }
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            default:
//                return "";
//        }
//    }
//}