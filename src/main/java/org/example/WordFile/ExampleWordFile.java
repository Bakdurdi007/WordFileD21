package org.example.WordFile;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleWordFile {
    public static void main(String[] args) {

        XWPFDocument doc4 = new XWPFDocument();

        XWPFParagraph paragraph = doc4.createParagraph();

        XWPFRun run = paragraph.createRun();

        run.setText("What is Lorem Ipsum?");
        run.setBold(true);
        run.setItalic(true);
        run.setFontSize(16);
        run.setFontFamily("DauphinPlain");

        XWPFParagraph paragraph2 = doc4.createParagraph();

        XWPFRun run2 = paragraph2.createRun();

        run2.setText("Lorem Ipsum");
        run2.setBold(true);
        run2.setFontSize(14);
        run2.setFontFamily("Arial");

        XWPFParagraph paragraph3 = doc4.createParagraph();

        XWPFRun run3 = paragraph3.createRun();

        run3.setText(" is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        run3.setFontSize(14);
        run3.setFontFamily("Arial");

        try {

            FileOutputStream fos = new FileOutputStream("DataBase/MyDocFile4.doc");

            doc4.write(fos);
            fos.close();
            doc4.close();

            System.out.println(" Word file muvoffaqiyatli yaratildi! ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
