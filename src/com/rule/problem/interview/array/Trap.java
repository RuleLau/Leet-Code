package com.rule.problem.interview.array;

public class Trap {

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int max = -1;
        int h = 0;
        //找到最高点和它的高度
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                h = i;
            }
        }
        int stan = 0, ans = 0;
        //从前遍历到最高点
        for (int i = 0; i < h; i++) {
            if (height[i] > stan) {
                stan = height[i];
            } else {
                ans += stan - height[i];
            }
        }
        stan = 0;//stan归零
        //从后遍历到最高点
        for (int i = height.length - 1; i > h; i--) {
            if (height[i] > stan) {
                stan = height[i];
            } else {
                ans += stan - height[i];
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
