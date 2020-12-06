package com.rule.problem.week;

import java.util.HashMap;
import java.util.Map;

public class Week218 {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }


    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                integer = 0;
            }
            map.put(nums[i], integer + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer sum = map.get(k - nums[i]);
            if (nums[i] == k - nums[i]) {
                if (sum != null && sum >= 2) {
                    if (sum - 2 == 0) {
                        map.remove(nums[i]);
                    } else {
                        map.put(nums[i], sum - 2);
                    }
                    ans++;
                }
            } else {
                Integer curr = map.get(nums[i]);
                if (curr != null && curr >= 1 && sum != null && sum >= 1) {
                    if (curr - 1 == 0) {
                        map.remove(nums[i]);
                    } else {
                        map.put(nums[i], curr - 1);
                    }
                    if (sum - 1 == 0) {
                        map.remove(k - nums[i]);
                    } else {
                        map.put(k - nums[i], sum - 1);

                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    public int concatenatedBinary(int n) {
        int sum = 0, m = 1000000007;
        for(int i = 1; i <= n; i++){
            int tmp = i;
            while(tmp > 0){
                sum *= 2;
                if(sum > m){
                    sum %= m;
                }
                tmp /= 2;
            }
            sum += i;
        }
        return sum % m;
    }

    public static void main(String[] args) {
        Week218 week218 = new Week218();
        week218.maxOperations(new int[]{2, 2, 2, 3, 1, 1, 4, 1}, 4);
    }
}
