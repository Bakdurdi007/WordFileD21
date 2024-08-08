package org.example.WordFile;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateParagrafDocFile {
    public static void main(String[] args) {

        XWPFDocument doc2 = new XWPFDocument();

        XWPFParagraph paragraph = doc2.createParagraph();

        paragraph.createRun().setText("Assalom alaykum! Men word filega ilk bor matn yozyabman! ");

        try {

            FileOutputStream fos = new FileOutputStream("DataBase/MyDocFile2.doc");

            doc2.write(fos);
            fos.close();
            doc2.close();

            System.out.println(" Word file muvoffaqiyatli yaratildi! ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
