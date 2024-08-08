package org.example.Post;

import org.example.TelegramBot.Bot;
import org.example.TelegramBot.DataBaseCounts;

import java.util.ArrayList;
import java.util.Scanner;

public class PostService {

    public static void PostMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 1. -> Rasmli post yaratish. ");
        System.out.println(" 2. -> Video post yaratish. ");
        System.out.println(" 3. -> Gif post yaratish. ");
        System.out.println(" 4. -> Fil post yaratish. ");
        System.out.println(" 0. -> Dasturdan chiqish. ");
        System.out.print(" >>> ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                PhotoPost();
                break;
        }

    }

    public static void PhotoPost() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.print(" Rasm manzilini kirting url: ");
        String PhotoUrl = sc.nextLine();

        System.out.print(" Mavzu nomini kirting title: ");
        String PhotoTitle = sc.nextLine();

        System.out.print(" Mavzu haqida ma'lumot info: ");
        String PhotoInfo = sc.nextLine();

        System.out.print(" Postda nechta link qo'shmoqchisiz? n: ");
        int n = sc1.nextInt();

        ArrayList<String> Url = new ArrayList<>();
        ArrayList<String> TextName = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print(" Name: ");
            TextName.add(sc.nextLine());

            System.out.print(" URL: ");
            Url.add(sc.nextLine());
        }

        String post = "";

        post = post + "<b>" + PhotoTitle + "</b>\n\n";
        post = post + PhotoInfo + "\n\n";

        for (int i = 0; i < n; i++) {
            post = post + "<a href=\"" + Url.get(i) + "\">" + TextName.get(i) + "</a> \n\n";
        }


        System.out.println(" IMG URL: " + PhotoUrl);
        System.out.println(" IMG TITLE: " + post);

        DataBaseCounts.Text = post;
        DataBaseCounts.URL = PhotoUrl;
    }

}
