package com.rule.problem.week;

import java.util.*;

public class Week179 {

    /**
     * 1374. Generate a String With Characters That Have Odd Counts
     */
    public static String generateTheString(int n) {
        char[] characters = new char[]{'a', 'b', 'c'};
        StringBuilder str = new StringBuilder();
        if (n == 1) {
            return str.append(characters[0]).toString();
        }
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                str.append(characters[0]);
            }
            str.append(characters[1]);
        } else {
            for (int i = 0; i < n - 2; i++) {
                str.append(characters[0]);
            }
            str.append(characters[1]);
            str.append(characters[2]);
        }
        return str.toString();
    }

    /**
     * 1375. Bulb Switcher III 0 = off 1 = on 2 = blue O(n) = n * n long time
     */
    public static int numTimesAllBlue(int[] light) {
        int n = light.length;
        int count = 0;
        int[] blue = new int[n];
        for (int value : light) {
            blue[value - 1] = 1;
            if (checkIsAllBlue(blue, value - 1)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkIsAllBlue(int[] blue, int index) {
        for (int i = 0; i < index; i++) {
            if (blue[i] == 0) {
                return false;
            }
        }
        blue[index] = 2;
        for (int i = index; i < blue.length; i++) {
            if (blue[i] == 2) {
                if (i < blue.length - 1 && blue[i + 1] == 1) {
                    blue[i + 1] = 2;
                }
            }
            if (blue[i] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1375. Bulb Switcher III 0 = off 1 = on 2 = blue worst O(n) = n * n accept
     */
    public static int numTimesAllBlue2(int[] light) {
        int n = light.length;
        int count = 0;
        int[] dp = new int[n + 1];
        int[] blue = new int[n + 1];
        blue[0] = 2;
        dp[0] = 1;
        for (int value : light) {
            blue[value] = 1;
            if (checkIsAllBlue2(blue, dp, value)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkIsAllBlue2(int[] blue, int[] dp, int index) {
        int n = blue.length;
        int flag = index;
        if (dp[index - 1] == 1) {
            blue[index] = 2;
            dp[index] = 1;
            for (int i = index; i < n - 1; i++) {
                if (dp[i] == 1 && blue[i + 1] == 1) {
                    blue[i + 1] = 2;
                    dp[i + 1] = 1;
                } else {
                    flag = i;
                    break;
                }
            }
            for (int i = flag; i < n; i++) {
                if (blue[i] == 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 1375. Bulb Switcher III 0 = off 1 = on 2 = blue worst O(n) = n accept
     */
    public static int numTimesAllBlue3(int[] light) {
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < light.length - 1; i++) {
            pq.offer(light[i]);
            int cur = Optional.ofNullable(pq.poll()).orElse(0);
            if (cur == i + 1)
                count++;
            pq.offer(cur);
        }
        return count;
    }

    /**
     * 1376. Time Needed to Inform All Employees  long time
     */
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return informTime[0];
        }
        int cost = 0;
        int[] dp = new int[n];
        dfs(headID, manager, informTime, dp);
        for (int value : dp) {
            cost = Math.max(cost, value);
        }
        return cost ;
    }

    private static void dfs(int headID, int[] manager, int[] informTime, int[] dp) {
        List<Integer> children = new ArrayList<>();
        if (informTime[headID] == 0) {
            return;
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1 && manager[i] == headID) {
                children.add(i);
                dp[i] = dp[headID] + informTime[headID];
                manager[i] = -1;
            }
        }
        if (children.isEmpty()) {
            return;
        }
        for (Integer child : children) {
            dfs(child, manager, informTime, dp);
        }

    }


    public static void main(String[] args) {
//        System.out.println(generateTheString(6));
//        System.out.println(numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
//        System.out.println(numTimesAllBlue2(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
    }
}
