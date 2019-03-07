package util;

import java.util.Random;

public class NumberGenerator {
    private final static String letters = "АБВГДЕЖИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private final static String numbers = "0123456789";
    private final static int N1 = letters.length();
    private final static int N2 = numbers.length();
    private final static Random r = new Random();

    public static String generate(){
        StringBuilder sb = new StringBuilder();
        sb.append(letters.charAt(r.nextInt(N1)));
        sb.append(numbers.charAt(r.nextInt(N2)));
        sb.append(numbers.charAt(r.nextInt(N2)));
        sb.append(numbers.charAt(r.nextInt(N2)));
        sb.append(letters.charAt(r.nextInt(N1)));
        sb.append(letters.charAt(r.nextInt(N1)));
        return new String(sb);
    }
}
