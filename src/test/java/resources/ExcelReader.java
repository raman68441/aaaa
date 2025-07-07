package resources;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public Map<String, String> getTestData(String filePath, String sheetName) {
        Map<String, String> data = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row header = sheet.getRow(0);
            Row row = sheet.getRow(1); // Read first data row

            for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
                data.put(header.getCell(i).getStringCellValue(), getCellValue(row.getCell(i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//kathrikiraman 
        return data;
    }
    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    }

