package org.example.WordFile;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateWordFile {
    public static void main(String[] args) {

        XWPFDocument doc = new XWPFDocument();

        try {

            FileOutputStream fos = new FileOutputStream("DataBase/MyDocFile.doc");

            doc.write(fos);
            fos.close();
            doc.close();

            System.out.println(" Word file muvoffaqiyatli yaratildi! ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}