package com.rule.problem;

/**
 * @description: 11 problem Container With Most Water
 * @author: rule
 * @date: 2019-11-16 11:41
 **/
public class ContainerWithMostWater {

    // O(n*n)
    public static int maxArea(int[] height) {
        int length = height.length;
        if (length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int left = height[i];
            for (int j = i + 1; j < length; j++) {
                int result = Math.min(left, height[j]) * (j - i);
                 max = max < result ? result :max ;
            }
        }
        return max;
    }

    //O(n)

    /**
     *  Solution explain:
     * The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line.
     * Further, the farther the lines, the more will be the area obtained.
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
     * Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now. At every step,
     * we find out the area formed between them, update \text{maxarea}maxarea and move the pointer pointing to the shorter line towards the other end by one step
     */
    public static int maxArea2(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int head = 0;
        int tail = height.length - 1;
        int max = 0;
        while (head < tail) {
            max = Math.max(Math.min(height[head], height[tail]) * (tail - head), max);
            if (height[head] < height[tail]) {
                head++;
            }else {
                tail--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        //System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}
