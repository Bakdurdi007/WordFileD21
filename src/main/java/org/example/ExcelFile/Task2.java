package org.example.ExcelFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print(" Enter row count: ");
        int rowCount = sc1.nextInt();

        System.out.print(" Enter sheet name: ");
        String sheetName = sc2.nextLine();

        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet(sheetName);

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("F.I.SH");

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("AGE");

        Cell cell3 = row.createCell(2);
        cell3.setCellValue("PHONENUMBER");

        Cell cell4 = row.createCell(3);
        cell4.setCellValue("ADDRESS");

        Cell cell5 = row.createCell(4);
        cell5.setCellValue("EMAIL");

        Cell cell6 = row.createCell(5);
        cell6.setCellValue("PASSWORD");

        for (int i = 1; i <= rowCount; i++) {

            Row row1 = sheet.createRow(i);

            System.out.print(" Enter user full name......................: ");
            String fullName = sc2.nextLine();

            System.out.print(" Enter user age............................: ");
            int age = sc1.nextInt();

            System.out.print(" Enter user phonenumber....................: ");
            String phonenumber = sc2.nextLine();

            System.out.print(" Enter user address........................: ");
            String address = sc2.nextLine();

            System.out.print(" Enter user email..........................: ");
            String email = sc2.nextLine();

            System.out.print(" Enter user password.......................: ");
            String password = sc2.nextLine();


            Cell cell1 = row1.createCell(0);
            cell1.setCellValue(fullName);

            Cell cell21 = row1.createCell(1);
            cell21.setCellValue(age);

            Cell cell31 = row1.createCell(2);
            cell31.setCellValue(phonenumber);

            Cell cell41 = row1.createCell(3);
            cell41.setCellValue(address);

            Cell cell51 = row1.createCell(4);
            cell51.setCellValue(email);

            Cell cell61 = row1.createCell(5);
            cell61.setCellValue(password);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("DataBase/Excel file/GenerationD21.xlsx")) {
            wb.write(fileOutputStream);
            System.out.println("Successfully wrote to the file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
