
 package com.parameters;
 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
	public static String[] getRowData(int sheet, int row) throws IOException {
	    String filePath = "src\\test\\resources\\ExcelData\\Brands.xlsx";
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
 



