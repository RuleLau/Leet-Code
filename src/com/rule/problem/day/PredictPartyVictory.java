package com.rule.problem.day;

import java.util.ArrayDeque;
import java.util.Deque;

public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Deque<Integer> rDeque = new ArrayDeque<>();
        Deque<Integer> dDeque = new ArrayDeque<>();
        int[] flag = new int[chars.length];
        flag[0] = 1;
        if (chars[0] == 'R') {
            rDeque.add(0);
        } else {
            dDeque.add(0);
        }
        while (rDeque.isEmpty() || dDeque.isEmpty()) {
            for (int i = 0; i < chars.length; i++) {
                 if (chars[i] == 'R') {
                    if (dDeque.isEmpty()) {
                        rDeque.add(i);
                    }else {
                        dDeque.poll();
                        flag[i] = 1;
                    }
                } else {
                    if (rDeque.isEmpty()) {
                        rDeque.add(i);
                    }else {
                        flag[i] = 1;
                    }
                }
            }
        }
        return rDeque.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        System.out.println(new PredictPartyVictory().predictPartyVictory("DRRD"));
//        System.out.println(new PredictPartyVictory().predictPartyVictory("RDDDDRDR"));
        System.out.println(new PredictPartyVictory().predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }

}


