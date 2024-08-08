package org.example.ExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.TelegramBot.DataBaseCounts;

public class ReadExcelFile {

    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream(new File("DataBase/Excel file/Bot.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    String number = "";

                    switch (cell.getCellType()) {

                        case NUMERIC:
                            number = String.valueOf(cell.getNumericCellValue());
                            break;

                        case STRING:
                            number = cell.getStringCellValue();
                            break;
                    }

                    if(Character.isDigit(number.charAt(0))) {
                        DataBaseCounts.UserID.add(Long.valueOf(number));
                    }
                    break;
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
