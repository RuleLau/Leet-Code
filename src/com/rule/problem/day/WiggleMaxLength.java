package com.rule.problem.day;

public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        for (int i = 0; i < 1; i++) {
            up[i] = 1;
            down[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            }else if (nums[i] > nums[i - 1]){
                down[i] = down[i - 1];
                up[i] = Math.max(down[i - 1] + 1, up[i - 1]);
            }else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}
