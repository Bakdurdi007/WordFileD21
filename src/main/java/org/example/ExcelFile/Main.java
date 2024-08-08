package org.example.ExcelFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("GenerationD21");

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Niyozmetov Abdulaziz");

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("15 yoshda");

        Cell cell3 = row.createCell(2);
        cell3.setCellValue("+998977107574");

        // - - - - - - - - - - - - - - - - - - - - - - - - -

        Row row2 = sheet.createRow(1);

        Cell cell4 = row2.createCell(0);
        cell4.setCellValue("Baxtiyorov Bekzodbek");

        Cell cell5 = row2.createCell(1);
        cell5.setCellValue("16 yoshda");

        Cell cell6 = row2.createCell(2);
        cell6.setCellValue("+998993632008");

        try (FileOutputStream fileOutputStream = new FileOutputStream("DataBase/Excel file/GenerationD21.xlsx")){
            wb.write(fileOutputStream);
            System.out.println("Successfully wrote to the file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
