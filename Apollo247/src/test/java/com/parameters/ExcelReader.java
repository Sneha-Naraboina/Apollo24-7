package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
    private XSSFWorkbook workbook;
    

    public void readExcel() throws IOException {
    	FileInputStream fileInput = new FileInputStream("src/test/resources/ExcelReader/Book3.xlsx");
        workbook = new XSSFWorkbook(fileInput);
    }

    public String[] readExcelFile(int sheetno, int rowno) {
        String[] rowData = null;
        try {
            XSSFSheet sheet = workbook.getSheetAt(sheetno);
            XSSFRow row = sheet.getRow(rowno);

            if (row != null) {
                int cellCount = row.getLastCellNum();
                rowData = new String[cellCount];
                for (int j = 0; j < cellCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    rowData[j] = (cell != null) ? cell.toString() : "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public String getCellData(String sheetName, int row, int col) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow sheetRow = sheet.getRow(row);
        if (sheetRow == null) return "";
        XSSFCell cell = sheetRow.getCell(col);
        return (cell != null) ? cell.toString() : "";
    }
    public String getCellData1(int sheetno,int row) {
		XSSFSheet sheet=workbook.getSheetAt(sheetno);
		XSSFRow sheetRow=sheet.getRow(row);
		XSSFCell cell=sheetRow.getCell(0);
		return cell.toString();
		
	}

    public void printAllData() {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            System.out.println(sheet.getSheetName());
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row == null) continue;
                for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
                    XSSFCell cell = row.getCell(colIndex);
                    System.out.print((cell != null ? cell.toString() : "") + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExcelReader reader = new ExcelReader();
        reader.readExcel();
        reader.printAllData();
        reader.workbook.close();
    }
}