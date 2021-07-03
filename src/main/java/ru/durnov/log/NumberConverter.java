package ru.durnov.log;

import java.util.HashMap;
import java.util.Map;

public class NumberConverter {
    private static final Map<String,String> map16To2 = new HashMap<>();
    private static final Map<String,Integer> map16To10 = new HashMap<>();
    private static final Map<String,String> map10To2 = new HashMap<>();

    static {
        fill16To2Map();
        fill16To10Map();
        fill10To2Map();
    }

    private static void fill10To2Map() {
        map10To2.put("0", "0000");
        map10To2.put("1", "01"); map10To2.put("2", "10");
        map10To2.put("3", "11"); map10To2.put("4", "100");
        map10To2.put("5", "101"); map10To2.put("6", "110");
        map10To2.put("7", "111"); map10To2.put("8", "1000");
        map10To2.put("9", "1001");

    }

    private static void fill16To10Map() {
        map16To10.put("0", 0); map16To10.put("1", 1); map16To10.put("2", 2);
        map16To10.put("3", 3); map16To10.put("4", 4); map16To10.put("5", 5);
        map16To10.put("6", 6); map16To10.put("7", 7); map16To10.put("8", 8);
        map16To10.put("9", 9);
        map16To10.put("A", 10); map16To10.put("B", 11);
        map16To10.put("C", 12); map16To10.put("D", 13);
        map16To10.put("E", 14); map16To10.put("F", 15);
    }

    private static void fill16To2Map() {
        map16To2.put("0", "0000");
        map16To2.put("1", "0001"); map16To2.put("2", "0010");
        map16To2.put("3", "0011"); map16To2.put("4", "0100");
        map16To2.put("5", "0101"); map16To2.put("6", "0110");
        map16To2.put("7", "0111"); map16To2.put("8", "1000");
        map16To2.put("9", "1001"); map16To2.put("A", "1010");
        map16To2.put("B", "1011"); map16To2.put("C", "1100");
        map16To2.put("D", "1101"); map16To2.put("E","1110");
        map16To2.put("F", "1111");
    }


    public static String convertFrom16To10(String string16){
        int result = 0;
        for (int i = 0; i < string16.length(); i++){
            String ch = String.valueOf(string16.charAt(string16.length() - 1 - i));
            int value = map16To10.get(ch) * ((int) Math.pow(16,i));
            result +=value;
        }
        return String.valueOf(result);
    }

    public static String convertFrom16To2(String string16){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <string16.length(); i++){
            String ch = String.valueOf(string16.charAt(i));
            result.append(map16To2.get(ch));
        }
        return String.valueOf(result);
    }

    public static String convertFrom10To2(String string10){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <string10.length(); i++){
            int index = string10.length() - 1 - i;
            String ch = String.valueOf(string10.charAt(index));
            result.append(map10To2.get(ch));
        }
        return String.valueOf(result);
    }

    public static String convert2To10(String string2){
        int result = 0;
        for (int i = 0; i < string2.length(); i++){
            int index = string2.length() - 1 - i;
            int value = Integer.parseInt(String.valueOf(string2.charAt(index)));
            result += value * ((int) Math.pow(2, i));
        }
        return String.valueOf(result);
    }
}
