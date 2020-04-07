package com.rule.problem.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week182 {

    /**
     * 5368. Find Lucky Integer in an Array
     */
    public static int findLucky(int[] arr) {
        int luck = -1;
        int[] fre = new int[500];
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            fre[a]++;
        }
        for (int i = 0; i < fre.length; i++) {
            if (fre[i] != 0 && i == fre[i]) {
                luck = Math.max(luck, i);
            }
        }
        return luck;
    }

    /**
     * 5369. Count Number of Teams
     */
    public static int numTeams(int[] rating) {
        int sum = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k])
                    || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    /**
     *  5370. Design Underground System
     */
    static class UndergroundSystem {

        private class Node {
            String stationName;
            int time;

            Node(String n, int t) {
                stationName = n;
                time = t;
            }
        }
        private Map<Integer, Node> map;
        private Map<String, Integer> totalTime;
        private Map<String, Integer> count;

        public UndergroundSystem() {
            map = new HashMap<>();
            totalTime = new HashMap<>();
            count = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            if(map.containsKey(id)) return;
            map.put(id, new Node(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            if(!map.containsKey(id)) return;
            Node node = map.remove(id);

            String key = node.stationName + "_" + stationName;
            int val = t - node.time;

            if(!totalTime.containsKey(key)) {
                totalTime.put(key, val);
                count.put(key, 1);
            } else { // contains this route
                totalTime.put(key, totalTime.get(key) + val);
                count.put(key, count.get(key) + 1);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "_" + endStation;
            double avg = 0.0;

            if(totalTime.containsKey(key)) {
                int total = totalTime.get(key);
                int num = count.get(key);
                avg = (double)total / num;
            }
            return avg;
        }
    }


    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(653777,"V3BOL9LF",71);
        undergroundSystem.checkIn(34036,"EFB2ARPR",86);
        undergroundSystem.checkOut(34036,"SEKKQ7KR",169);
        undergroundSystem.checkIn(476790,"U54HBTYV",223);
        undergroundSystem.getAverageTime("EFB2ARPR","SEKKQ7KR");
        undergroundSystem.getAverageTime("EFB2ARPR","SEKKQ7KR");

        undergroundSystem.checkOut(476790,"SEKKQ7KR",226);
        undergroundSystem.checkOut(653777,"K2618O72",255);
        undergroundSystem.checkIn(680009,"U54HBTYV",342);
        undergroundSystem.checkIn(691876,"1DTINDTE",352);
        undergroundSystem.checkIn(779975,"0QIA9CN3",374);
        undergroundSystem.checkOut(691876,"WGN1M5GY",412);


        undergroundSystem.checkIn(18036,"ZSBKMUIV",467);
        undergroundSystem.getAverageTime("V3BOL9LF","K2618O72");
        undergroundSystem.checkOut(779975,"W858PECF",485);
        undergroundSystem.getAverageTime("U54HBTYV","SEKKQ7KR");
        undergroundSystem.checkOut(18036,"V6QXVVHS",516);
        undergroundSystem.checkIn(141921,"9GUC0EYJ",533);
    }



}
