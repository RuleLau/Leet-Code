package com.rule.problem.week;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

public class Week205 {
    public String modifyString(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        if (s.indexOf('?') == -1) {
            return s;
        }
        if ("?".equals(s)) {
            return "a";
        }
        for (int i = 0; i < len - 1; i++) {
            if (sb.charAt(i) == '?') {
                if (i == 0) {
                    if (sb.charAt(i + 1) == 'a') {
                        sb.setCharAt(i, 'b');
                    } else {
                        sb.setCharAt(i, 'a');
                    }
                } else {
                    char a = sb.charAt(i - 1);
                    char b = sb.charAt(i + 1);
                    int min = Math.min(a, b);
                    if (b != '?') {
                        if (a - b == 1 || b - a == 1) {
                            if (min != 'a') {
                                sb.setCharAt(i, (char) (min - 1));
                            } else {
                                sb.setCharAt(i, 'c');
                            }
                        } else {
                            if (min != 'z') {
                                sb.setCharAt(i, (char) (min + 1));
                            } else {
                                sb.setCharAt(i, (char) (min - 1));
                            }
                        }
                    } else {
                        if (a == 'a') {
                            sb.setCharAt(i, 'b');
                        } else {
                            sb.setCharAt(i, (char) (a - 1));
                        }
                    }
                }
            }
        }
        if (sb.charAt(len - 1) == '?') {
            if (sb.charAt(len - 2) == 'a') {
                sb.setCharAt(len - 1, 'b');
            } else {
                sb.setCharAt(len - 1, 'a');
            }

        }
        return sb.toString();
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            int s1 = nums1[i] * nums1[i];
            for (int j = 0; j < nums2.length - 1; j++) {
                if (s1 < nums2[j] * nums2[j]) {
                    break;
                }
                for (int k = j + 1; k < nums2.length; k++) {
                    int s2 = nums2[j] * nums2[k];
                    if (s1 == s2) {
                        ans++;
                    } else if (s1 < s2) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int s1 = nums2[i] * nums2[i];
            for (int j = 0; j < nums1.length - 1; j++) {
                if (s1 < nums1[j] * nums1[j]) {
                    break;
                }
                for (int k = j + 1; k < nums1.length; k++) {
                    int s2 = nums1[j] * nums1[k];
                    if (s1 == s2) {
                        ans++;
                    } else if (s1 < s2) {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int minCost(String s, int[] cost) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                sum += Math.min(cost[i], cost[i + 1]);
                if (cost[i] > cost[i + 1]) {
                    int temp = cost[i + 1];
                    cost[i + 1] = cost[i];
                    cost[i] = temp;
                }
            }
        }
        return sum;

    }


    public static void main(String[] args) {
        Week205 w = new Week205();
        //System.out.println(w.modifyString("j?qg??b"));
        System.out.println(w.numTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
    }

}
