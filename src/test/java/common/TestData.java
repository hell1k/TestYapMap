package common;

import java.util.Random;

public class TestData {
    public String login = "hatreruxawou-9704@yopmail.com";
    public String password = "Qq12345678!";

    private static final Random random = new Random();

    public static String getFirstName() {
        return "John" + random.nextInt(10000);
    }

    public static String getLastName() {
        return "Doe" + random.nextInt(10000);
    }

    public static String getNickname() {
        return "nickname" + random.nextInt(99999);
    }

    public static String getRandomNumber(int length) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < length; i++) {
            digits.append(random.nextInt(10)); // генерирует от 0 до 9
        }
        return digits.toString();
    }
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        String userName = sb.toString();

        // Генерация случайного домена
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "mail.com"};
        String domain = domains[random.nextInt(domains.length)];

        return userName + "@" + domain;
    }
}
