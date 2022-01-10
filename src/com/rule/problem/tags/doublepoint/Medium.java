package com.rule.problem.tags.doublepoint;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

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

    /**
     * 413. 等差数列划分
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int l = 0;
        while (l < len - 2) {
            int a = nums[l + 1] - nums[l];
            int r = l + 2;
            while (r < len && nums[r] - nums[r - 1] == a) {
                ans++;
                r++;
            }
            l++;
        }
        return ans;
    }

    /**
     * 424. 替换后的最长重复字符
     */
    public int characterReplacement(String s, int k) {
        int l = 0;
        int len = s.length();
        if (len <= k) {
            return len;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int idx = chars[i] - 'A';
            map[idx]++;
            max = Math.max(map[idx], max);
            if (i - l + 1 > max + k) {
                map[chars[l] - 'A']--;
                l++;
            }
        }
        return len - l;
    }

    /**
     * 443. 压缩字符串
     */
    public static int compress(char[] chars) {
        int length = chars.length;
        int l = 0;
        int r = 0;
        StringBuilder ans = new StringBuilder();
        int sum = 0;
        while (r < length) {
            if (chars[r] == chars[l]) {
                sum++;
                r++;
            } else {
                ans.append(chars[l]);
                if (sum != 1) {
                    ans.append(sum);
                }
                sum = 0;
                l = r;
            }
        }
        ans.append(chars[length - 1]);
        if (sum != 1) {
            ans.append(sum);
        }
        char[] array = ans.toString().toCharArray();
        System.arraycopy(array, 0, chars, 0, array.length);
        return array.length;
    }

    /**
     * 475. 供暖器
     */
    public static int findRadius(int[] houses, int[] heaters) {
        int ans = Integer.MAX_VALUE;
        int[] map = new int[30001];
        TreeSet<Integer> set = new TreeSet<>();

        for (int heater : heaters) {
            map[heater]++;
            set.add(heater);
        }
        for (int house : houses) {
            set.add(house);
        }
        List<Integer> total = new ArrayList<>(set);
        int l = 0;
        int size = total.size();
        for (int i = 0; i < size; i++) {
            if (map[total.get(i)] != 0) {
                int r = i;
                int dis = total.get(r) - total.get(l);
                int max = Integer.MIN_VALUE;
                ;
                if (map[total.get(l)] == 0) {
                    max = dis;
                } else {
                    max = Math.max(max, dis % 2 == 0 ? dis / 2 : dis / 2 + 1);
                }

                while (r < size && map[total.get(r)] == 0) {
                    r++;
                }
                int rdis = total.get(r - 1) - total.get(i);
                if (r == size) {
                    max = Math.max(max, rdis);
                } else {
                    max = Math.max(max, rdis % 2 == 0 ? rdis / 2 : rdis / 2 + 1);
                }
                ans = Math.min(ans, max);
            }
        }
        return ans;
    }

    /**
     * 825. 适龄的朋友
     */
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int len = ages.length;
        int[] tmp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            tmp[len - i - 1] = ages[i];
        }
        int left = 0;
        while (left < len - 1) {
            int right = left + 1;
            while (right < len) {
                if (tmp[right] > 0.5 * tmp[left] + 7) {
                    ans++;
                } else {
                    break;
                }
                if (tmp[left] == tmp[right] && tmp[left] > 0.5 * tmp[right] + 7) {
                    ans++;
                }
                right++;
            }
            left++;
        }
        return ans;
    }

    /**
     * 881. 救生艇
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int len = people.length;
        if (people[0] >= limit) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 930. 和相同的二元子数组
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        while (right < len) {
            sum += nums[right];
            if (sum == goal) {
                ans++;
            } else if (sum > goal) {
                while (left < right && sum - nums[left] != goal) {
                    left++;
                }
            }
            while (left < right && sum - nums[left] == goal) {
                sum = sum - nums[left];
                ans++;
                left++;
            }
            left = 0;
            right++;
        }
        return ans;
    }


    /**
     * 1004. 最大连续1的个数 III
     */
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (right < len) {
            if (nums[right] == 0) {
                cnt++;
                while (cnt > k) {
                    if (nums[left++] == 0) {
                        cnt--;
                    }
                }
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    /**
     * 1052. 爱生气的书店老板
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }
        int left = 0;
        int right = 0;
        int len = customers.length;
        int sum = 0;
        int max = 0;
        int cnt = 0;
        while (right < len) {
            cnt++;
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            max = Math.max(sum, max);
            if (cnt == minutes) {
                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }
                left++;
                cnt--;
            }
            right++;
        }
        return ans + max;
    }

    /**
     * 1743. 从相邻元素对还原数组
     */
    public static int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            List<Integer> list = map.getOrDefault(adjacentPair[0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
            list.add(adjacentPair[1]);
            list2.add(adjacentPair[0]);
            map.put(adjacentPair[0], list);
            map.put(adjacentPair[1], list2);
        }
        int[] ans = new int[len + 1];
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                break;
            }
        }
        ans[len] = ans[1];
        int start = ans[0];
        ans[1] = map.get(start).get(0);
        for (int i = 2; i < len + 1; i++) {
            int x = ans[i - 1];
            List<Integer> list = map.get(x);
            for (int j : list) {
                if (j != ans[i - 2]) ans[i] = j;
            }
        }
        return ans;
    }

    /**
     * 1764. 通过连接另一个数组的子数组得到一个数组
     */
    public static boolean canChoose(int[][] groups, int[] nums) {
        StringBuilder numsStr = new StringBuilder();
        for (int num : nums) {
            numsStr.append(num).append(",");
        }
        numsStr.deleteCharAt(numsStr.length() - 1);
        int k = Integer.MIN_VALUE;
        for (int[] group : groups) {
            StringBuilder tmp = new StringBuilder();
            for (int i : group) {
                tmp.append(i).append(",");
            }
            tmp.deleteCharAt(tmp.length() - 1);
            int a = numsStr.indexOf(tmp.toString());
            int i = numsStr.lastIndexOf(tmp.toString());
            // System.out.println(i);
            if (i == -1) {
                return false;
            }
            if (i <= k) {
                return false;
            }
            if (i != 0 && numsStr.charAt(i - 1) != ',') {
                return false;
            }
            a += tmp.length() - 1;
            k = a;
            tmp.setLength(0);
        }
        return true;
    }

    public static void main(String[] args) {
        Medium medium = new Medium();
//        medium.lengthOfLongestSubstring("sxhkbbcdfxnmqkat");
//        System.out.println(medium.jump(new int[]{4, 1, 1, 3, 1, 1, 1}));
//        numberOfArithmeticSlices(new int[]{1, 2, 2, 3, 4});
//        compress(new char[]{'a', 'c', 'b', 'b', 'c', 'c', 'c'});
//        findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
//        numFriendRequests(new int[]{16, 17, 18, 16});
//        numSubarraysWithSum(new int[]{0, 1, 1, 1, 1}, 3);
//        maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        canChoose(new int[][]{{1, 2, 3}, {3, 4}}
                , new int[]{7, 7, 1, 2, 3, 4, 7, 7});
    }

}
