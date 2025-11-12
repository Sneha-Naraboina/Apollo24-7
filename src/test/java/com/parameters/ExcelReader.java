package com.parameters;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
    File f;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sh;
 
    public ExcelReader(String filepath) {
        try {
            f = new File(filepath);
            fis = new FileInputStream(f);
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public String getCellData(int sheetno, int row, int col) {
        sh = wb.getSheetAt(sheetno);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sh.getRow(row).getCell(col));
    }
}

