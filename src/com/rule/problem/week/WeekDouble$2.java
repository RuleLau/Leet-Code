package com.rule.problem.week;

import java.math.BigDecimal;
import java.util.*;

public class WeekDouble$2 {

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stu = new ArrayDeque<>();
        Deque<Integer> sand = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            stu.addLast(students[i]);
            sand.addLast(sandwiches[i]);
        }
        int flag = 0;
        while (!stu.isEmpty() && !sand.isEmpty()) {
            int currStu = stu.peek();
            if (currStu != sand.peek()) {
                flag++;
                stu.poll();
                stu.add(currStu);
            } else {
                flag = 0;
                stu.poll();
                sand.poll();
            }
            if (flag == stu.size()) {
                break;
            }
        }
        return stu.size();
    }

    public double averageWaitingTime(int[][] customers) {
        double ans = customers[0][1];
        double finish = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            int[] customer = customers[i];
            if (finish > customer[0]) {
                finish = finish + customer[1];
                ans += (finish - customer[0]);
            } else {
                finish = customer[0] + customer[1];
                ans += customer[1];
            }
        }
        BigDecimal b = new BigDecimal(ans / customers.length);
        BigDecimal bigDecimal = b.setScale(5, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {


        }

        return ans.toString();
    }


    public static void main(String[] args) {
        WeekDouble$2 weekDouble$2 = new WeekDouble$2();
        weekDouble$2.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
    }


}
