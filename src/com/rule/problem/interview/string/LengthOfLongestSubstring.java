package com.rule.problem.interview.string;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    /**
     * 3. 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        Thread wait = new Thread(new Wait(), "wait");
        Thread notify = new Thread(new Notify(), "notify");
        wait.start();
        Thread.sleep(1000);
        notify.start();
    }


    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true");
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println("get lock finished");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                flag = false;
                System.out.println(Thread.currentThread() + "flag is false");
                lock.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
