package org.example.WordFile;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateRunWordFile {
    public static void main(String[] args) {
        XWPFDocument doc3 = new XWPFDocument();

        XWPFParagraph paragraph = doc3.createParagraph();

        XWPFRun run = paragraph.createRun();

        run.setText("Assalom alaykum! Men word filega ilk bor matn yozyabman! ");
        run.setColor("FF0909");
        run.setBold(true);
        run.setItalic(true);
        run.setFontSize(20);

        try {

            FileOutputStream fos = new FileOutputStream("DataBase/MyDocFile3.doc");

            doc3.write(fos);
            fos.close();
            doc3.close();

            System.out.println(" Word file muvoffaqiyatli yaratildi! ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
