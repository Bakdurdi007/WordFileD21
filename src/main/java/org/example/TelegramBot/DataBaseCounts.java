package org.example.TelegramBot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseCounts {
    public static Map<Integer, Long> UserChatID = new HashMap<>();
    public static Map<Integer, String> UserName = new HashMap<>();
    public static Map<Integer, String> UserLastName = new HashMap<>();
    public static Map<Integer, String> UserFirstName = new HashMap<>();
    public static ArrayList<Long> UserID = new ArrayList<>();

    public static String URL = "";
    public static String Text = "";
    public static int count = 0;
}
