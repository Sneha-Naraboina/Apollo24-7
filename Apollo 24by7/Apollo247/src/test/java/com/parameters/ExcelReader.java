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
        String path = System.getProperty("user.dir") + "/src/test/resources/ExcelReader/Book3.xlsx";
        FileInputStream fileInput = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInput);
    }

    public String getCellData(String sheetName, int row, int col) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return "";
        XSSFRow sheetRow = sheet.getRow(row);
        if (sheetRow == null) return "";
        XSSFCell cell = sheetRow.getCell(col);
        return (cell != null) ? cell.toString() : "";
    }

    public String getCellData1(int sheetNo, int row) {
        XSSFSheet sheet = workbook.getSheetAt(sheetNo);
        if (sheet == null) return "";
        XSSFRow sheetRow = sheet.getRow(row);
        if (sheetRow == null) return "";
        XSSFCell cell = sheetRow.getCell(0);
        return (cell != null) ? cell.toString() : "";
    }

    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}