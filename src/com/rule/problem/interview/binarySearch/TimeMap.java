package com.rule.problem.interview.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. 基于时间的键值存储 超时
 * @description:
 * @author: rule
 * @date: 2020-07-13 22:27
 **/
public class TimeMap {

    Map<String, List<Integer>> map = null;

    Map<String, String> timeMap = null;

    public TimeMap() {
        map = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Integer> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
        }
        values.add(timestamp);
        Collections.sort(values);
        map.put(key, values);
        timeMap.put(key + "-" + timestamp, value);
    }

    public String get(String key, int timestamp) {
        List<Integer> list = map.get(key);
        if (list == null) {
            return "";
        }
        //直接获取值
        String s = timeMap.get(key + "-" + timestamp);
        if (s != null) {
            return s;
        }
        // 取<=timestamp的值
        // 取<=timestamp的值
        int left = 0;
        int right = list.size() - 1;
        while (left <= right && left >= 0 && right < list.size()) {
            int mid = (left + right) / 2;
            if (list.get(mid) < timestamp) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right < 0 ? "" : timeMap.get(key + "-" + list.get(right));
    }

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));

    }

}
