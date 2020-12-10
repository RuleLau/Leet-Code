package com.rule.problem.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: rule
 * @date: 2020-12-10 19:18
 **/
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length <= 1) {
            return true;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 10) {
                if (sum < 5) {
                    return false;
                }
                if (map.getOrDefault(5, 0) >= 1) {
                    map.put(5, map.get(5) - 1);
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (sum < 15) {
                    return false;
                }
                if (map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5,0) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else if (map.getOrDefault(5, 0) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }
            map.put(bills[i], map.getOrDefault(bills[i], 0) + 1);
            sum += 5;
        }
        return true;
    }

    public static void main(String[] args) {
        new LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20});
    }
}
