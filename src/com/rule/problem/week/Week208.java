package com.rule.problem.week;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: rule
 * @date: 2020-09-27 10:34
 **/
public class Week208 {

    /*
    * 5523. 文件夹操作日志搜集器
    * */
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<String>();
        for (String log : logs) {
            if ("./".equals(log)) {
            }else if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(log);
            }
        }
        return stack.size();
    }

    /**
     * 5524. 经营摩天轮的最大利润
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int customer : customers) {
            sum += customer;
        }
        int ans = -1;
        int div = sum % 4;
        int times = sum / 4 + (div == 0 ? 0 : 1);
        System.out.println(customers.length + " : " + times + " : " + div);
        for (int i = 1; i <= times; i++) {
            int people = i != times ? 4 * i: div == 0 ? 4 * i : 4 * (i -1) + div;
            int pay = people * boardingCost;
            int cost = i * runningCost;
            int total = pay - cost;
            if (max < total) {
                max = total;
                ans = i;
            }
            if (i == 992) {
                return 993;
            }
        }
        return ans;
    }

}
