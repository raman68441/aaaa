package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelReader {
    public static String email;
    public static String password;

    public static void readExcel() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(1);  // assuming 1st row is header, 2nd row is data
            email = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();

            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
