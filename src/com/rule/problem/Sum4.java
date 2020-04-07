package com.rule.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 18. 4Sum
 * @author: rule
 * @date: 2019-11-26 20:50
 **/
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                   
                }
            }
        }

        return result;
    }

}
