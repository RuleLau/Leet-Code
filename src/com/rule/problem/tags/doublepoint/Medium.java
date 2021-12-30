package com.rule.problem.tags.doublepoint;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Medium {

    /**
     * 3. 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Queue<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int sum = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Queue<Integer> queue = map.get(c);
            if (queue == null || queue.size() == 0) {
                if (queue == null) {
                    queue = new ArrayDeque<>();
                }
                queue.add(i);
                sum++;
                max = Math.max(sum, max);
            } else {
                Integer poll = queue.poll();
                max = Math.max(sum, max);
                if (last != -1 && last > poll) {
                    sum++;
                } else {
                    sum = i - poll;
                }
                queue.add(i);
                last = Math.max(poll, last);
            }
            map.put(c, queue);
        }
        return max;
    }

    /**
     * 3. 无重复字符的最长子串
     */
    public int lengthOfLongestSubstringII(String s) {
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

    /**
     * 11. 盛最多水的容器
     */
    public int maxArea(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int sum = 0;
        while (a < b) {
            sum = Math.max(sum, (b - a) * Math.min(height[a], height[b]));
            if (height[a] > height[b]) {
                b--;
            } else {
                a++;
            }
        }
        return sum;
    }

    /**
     * 45. 跳跃游戏 II
     */
    public int jump(int[] nums) {
        int ans = 0;
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < len - 1; ) {
            int pi = i + nums[i];
            if (pi >= len - 1) {
                ans++;
                return ans;
            }
            int pos = -1;
            for (int j = i + 1; j < len && j <= i + nums[i]; j++) {
                if (pos <= nums[j]) {
                    pos = nums[j];
                    pi = j;
                }
            }
            i = pi;
            ans++;
            if (pi >= len - 1) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Medium medium = new Medium();
//        medium.lengthOfLongestSubstring("sxhkbbcdfxnmqkat");
        System.out.println(medium.jump(new int[]{4,1,1,3,1,1,1}));
    }

}
