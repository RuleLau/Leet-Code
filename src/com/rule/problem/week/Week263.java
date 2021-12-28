package com.rule.problem.week;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Week263 {

    public static boolean areNumbersAscending(String s) {
        int min = Integer.MIN_VALUE;
        int sum = 0;
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            char[] number = isNumber(s2);
            if (number != null) {
                int i = Integer.parseInt(s2);
                sum++;
                if (i > min) {
                    min = i;
                } else {
                    return false;
                }
            }

        }
        return sum != 1;
    }

    private static char[] isNumber(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int i = aChar - 'a';
            if (i < -49 || i > -40) {
                return null;
            }
        }
        return chars;
    }

    class Bank {

        private long[] balance;
        private int accounts;

        public Bank(long[] balance) {
            this.balance = balance;
            this.accounts = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 < 0 || account1 > this.accounts || account2 < 0 || account2 > this.accounts) {
                return false;
            }
            long s1 = balance[account1 - 1];
            if (s1 < money) {
                return false;
            }

            balance[account1 - 1] = s1 - money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account < 0 || account > this.accounts) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account < 0 || account > this.accounts) {
                return false;
            }
            if (balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }
    }

    public static int countMaxOrSubsets(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int[] sum = new int[10000];
        List<Integer> list = new ArrayList<>(len);
        for (int num : nums) {
            list.add(num);
        }
        ArrayList<ArrayList<Integer>> dfs = dfs(list);
        for (ArrayList<Integer> df : dfs) {
            if (df.size() > 0) {
                int a = df.get(0);
                for (int i = 1; i < df.size(); i++) {
                    a = a | df.get(i);
                }
                sum[a]++;
                max = Math.max(a, max);
            }

        }
        return sum[max];
    }

    private static ArrayList<ArrayList<Integer>> dfs(List<Integer> subList) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();
        int max = 1 << subList.size();
        for (int loop = 0; loop < max; loop++) {
            int index = 0;
            int temp = loop;
            ArrayList<Integer> currentCharList = new ArrayList<Integer>();
            while (temp > 0) {
                if ((temp & 1) > 0) {
                    currentCharList.add(subList.get(index));
                }
                temp >>= 1;
                index++;
            }
            allsubsets.add(currentCharList);
        }
        return allsubsets;
    }


    public static void main(String[] args) {
//        System.out.println(areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));

        countMaxOrSubsets(new int[]{3,2,1,5});
    }
}
