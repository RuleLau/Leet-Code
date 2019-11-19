package com.rule.problem;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @description: 13. Roman to Integer
 * @author: rule
 * @date: 2019-11-16 17:02
 **/
public class Roman2Integer {
    private static HashMap<Integer, String> RomanToNum = new LinkedHashMap<>();

    static {
        RomanToNum.put(1000, "M");
        RomanToNum.put(900, "CM");
        RomanToNum.put(500, "D");
        RomanToNum.put(400, "CD");
        RomanToNum.put(100, "C");
        RomanToNum.put(90, "XC");
        RomanToNum.put(50, "L");
        RomanToNum.put(40, "XL");
        RomanToNum.put(10, "X");
        RomanToNum.put(9, "IX");
        RomanToNum.put(5, "V");
        RomanToNum.put(4, "IV");
        RomanToNum.put(1, "I");
    }

    public static int romanToInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int result = 0;
        while (s.length() > 0) {
            int flag = 0;
            if (s.length() >= 2) {
                switch (s.substring(0, 2)) {
                    case "IV": result+= 4; flag = 1; break;
                    case "IX": result+= 9; flag = 1; break;
                    case "XL": result+= 40; flag = 1; break;
                    case "XC": result+= 90; flag = 1; break;
                    case "CD": result+= 400; flag = 1; break;
                    case "CM": result+= 900; flag = 1; break;
                }
            }
            if (flag == 1) {
                s = s.substring(2, s.length());
            }else {
                switch (s.substring(0, 1)) {
                    case "I": result+= 1; break;
                    case "V": result+= 5; break;
                    case "X": result+= 10; break;
                    case "L": result+= 50; break;
                    case "C": result+= 100; break;
                    case "D": result+= 500; break;
                    case "M": result+= 1000; break;
                }
                s = s.substring(1, s.length());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
