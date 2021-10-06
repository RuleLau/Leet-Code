package com.rule.problem.practice;


/**
 * @description: 12. Integer to Roman
 * @author: rule
 * @date: 2019-11-16 16:00
 **/
public class Integer2Roman {
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder("");
        int time = 1;
        while (num != 0) {
            int flag = 0;
            int m = num % 10 * time;
            switch (m) {
                case 4:
                    result.append("VI");
                    flag = 1;
                    break;
                case 5:
                    result.append("V");
                    flag = 1;
                    break;
                case 9:
                    result.append("XI");
                    flag = 1;
                    break;
                case 10:
                    result.append("X");
                    flag = 1;
                    break;
                case 40:
                    result.append("LX");
                    flag = 1;
                    break;
                case 50:
                    result.append("L");
                    flag = 1;
                    break;
                case 90:
                    result.append("CX");
                    flag = 1;
                    break;
                case 100:
                    result.append("C");
                    flag = 1;
                    break;
                case 400:
                    result.append("DC");
                    flag = 1;
                    break;
                case 500:
                    result.append("D");
                    flag = 1;
                    break;
                case 900:
                    result.append("MC");
                    flag = 1;
                    break;
                case 1000:
                    result.append("M");
                    flag = 1;
                    break;
                default:
                    break;
            }
            if (flag == 0) {
                if (m < 4) {
                    for (int i = 0; i < m; i++) {
                        result.append("I");
                    }
                } else if (m > 5 && m < 9) {
                    for (int i = 0; i < m - 5; i++) {
                        result.append("I");
                    }
                    result.append("V");
                } else if (m > 10 && m < 40) {
                    for (int i = 0; i < m / 10; i++) {
                        result.append("X");
                    }
                } else if (m > 50 && m < 90) {
                    for (int i = 0; i < (m - 50) / 10; i++) {
                        result.append("X");
                    }
                    result.append("L");
                } else if (m > 100 && m < 400) {
                    for (int i = 0; i < m / 100; i++) {
                        result.append("C");
                    }
                } else if (m > 500 && m < 900) {
                    for (int i = 0; i < (m - 500) / 100; i++) {
                        result.append("C");
                    }
                    result.append("D");
                } else if (m > 1000) {
                    for (int i = 0; i < m / 1000; i++) {
                        result.append("M");
                    }
                }
            }
            time *= 10;
            num = num / 10;
        }
        return result.reverse().toString();
    }

    public static String intToRoman2(int num) {
        String[] M = new String[]{"", "M", "MM", "MMM"};
        String[] C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman2(1994));
    }
}
