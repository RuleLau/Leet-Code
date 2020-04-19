package com.rule.problem.week;

import java.util.*;

public class WeekDouble185 {

    /**
     * 5388. 重新格式化字符串
     */
    public String reformat(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean b = checkCharacter(c);
            if (b) {
                str1.append(c);
                flag1 = true;
            }

            if (!b && checkNumber(c)) {
                str2.append(c);
                flag2 = true;
            }
        }
        int len1 = str1.length();
        int len2 = str2.length();
        if (!flag1 || !flag2 || (Math.abs(len1 - len2) >= 2)) {
            return "";
        }
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (len1 < len2) {
                res.append(str2.charAt(j));
                res.append(str1.charAt(i));
            }else {
                res.append(str1.charAt(i));
                res.append(str2.charAt(j));
            }
            i++;
            j++;
        }

        while (i < len1) {
            res.append(str1.charAt(i));
            i++;
        }
        while (j < len2) {
            res.append(str2.charAt(i));
            j++;
        }
        return res.toString();

    }

    private boolean checkCharacter(Character character) {
        return character.compareTo('a') >= 0 && character.compareTo('z') <= 0;
    }

    private boolean checkNumber(Character character) {
        int number = Integer.parseInt(String.valueOf(character));
        return number >= 0 && number <= '9';
    }

    /**
     * 5389. 点菜展示表
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();
        Map<String, Map<String, Integer>> tables = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
        Set<String> foods = new TreeSet<>(String::compareTo);
        title.add("Table");
        for (List<String> order : orders) {
            String tableNum = order.get(1);
            String food = order.get(2);
            foods.add(food);
            Map<String, Integer> map = tables.get(tableNum);
            if (map == null) {
                map = new HashMap<>();
            }
            Integer count = map.get(food);
            map.put(food, count == null ? 1 : count + 1);
            tables.put(tableNum, map);
        }
        // 存储菜品
        title.addAll(foods);
        res.add(title);
        tables.forEach((k,v) -> {
            List<String> list = new ArrayList<>();
            list.add(k);
            for (int i = 1; i < title.size(); i++) {
                String food = title.get(i);
                Integer cnt = v.getOrDefault(food, 0);
                list.add(cnt.toString());
            }
            res.add(list);
        });

        return res;
    }


    public static void main(String[] args) {
        WeekDouble185 a = new WeekDouble185();
//        System.out.println(a.reformat("a0b1c2"));
//        System.out.println(a.reformat("leetcode"));
//        System.out.println(a.reformat("1229857369"));
//        System.out.println(a.reformat("covid2019"));
//        System.out.println(a.reformat("ab123"));
    }
}
