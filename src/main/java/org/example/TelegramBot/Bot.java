package org.example.TelegramBot;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "- - - - - - - - - - -";
    }

    @Override
    public String getBotToken() {
        return "- - - - - - - - - - -";
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();

        if (text.equals("/start")) {
            int id = DataBaseCounts.count;
            DataBaseCounts.UserChatID.put(id, update.getMessage().getChatId());
            DataBaseCounts.UserName.put(id, update.getMessage().getFrom().getUserName());
            DataBaseCounts.UserLastName.put(id, update.getMessage().getFrom().getLastName());
            DataBaseCounts.UserFirstName.put(id, update.getMessage().getFrom().getFirstName());

            id++;

            DataBaseCounts.count = id;

            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(String.valueOf(chatId));
            sendMessage.setText("<a href=\"https://www.w3schools.com\"> Dasturlashni o'rganish uchun manba tezroq kiring! </a>");
            sendMessage.setParseMode("HTML");

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }else if (text.equals("/write")) {

            Workbook wb = new XSSFWorkbook();

            Sheet sheet = wb.createSheet("DataBase");

            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue("TELEGRAM CHATID");

            Cell cell2 = row.createCell(1);
            cell2.setCellValue("TELEGRAM USER NAME");

            Cell cell3 = row.createCell(2);
            cell3.setCellValue("TELEGRAM LAST NAME");

            Cell cell41 = row.createCell(3);
            cell41.setCellValue("TELEGRAM FIRST NAME");

            // - - - - - - - - - - - - - - - - - - - - - - - - -

            for (int i = 0; i < DataBaseCounts.UserName.size(); i++) {
                Row row2 = sheet.createRow(i +1);

                String UserChatID = DataBaseCounts.UserChatID.get(i).toString();
                Cell cell4 = row2.createCell(0);
                cell4.setCellValue(UserChatID);

                String UserName = DataBaseCounts.UserName.get(i);
                Cell cell5 = row2.createCell(1);
                cell5.setCellValue(UserName);

                String UserLastName = DataBaseCounts.UserLastName.get(i);
                Cell cell6 = row2.createCell(2);
                cell6.setCellValue(UserLastName);

                String UserFirstName = DataBaseCounts.UserFirstName.get(i);
                Cell cell7 = row2.createCell(3);
                cell7.setCellValue(UserFirstName);
            }

            System.out.println(" Test1");

            try (FileOutputStream fileOutputStream = new FileOutputStream("DataBase/Excel file/Bot.xlsx")) {
                wb.write(fileOutputStream);
                System.out.println("Test2");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else if(text.equals("/photo")) {
            System.out.println(DataBaseCounts.Text);
            System.out.println(DataBaseCounts.URL);
            SendPhotoTelegram();
        }
    }

    public void SendPhotoTelegram(){
        for (int i = 0; i < DataBaseCounts.UserID.size(); i++) {
            SendPhoto sendPhoto = new SendPhoto();

            sendPhoto.setChatId(String.valueOf(DataBaseCounts.UserID.get(i)));

            sendPhoto.setPhoto(new InputFile(new File(DataBaseCounts.URL)));

            sendPhoto.setCaption(DataBaseCounts.Text);

            sendPhoto.setParseMode("HTML");

            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
