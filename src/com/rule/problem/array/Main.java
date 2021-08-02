package com.rule.problem.array;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {


    /**
     * 双指针判断，如果nums[i]!=nums[j],说明i-j之间存在重复项，然后将nums[j + 1] = nums[i]，
     * 进行元素的重新赋值，这也是删除重复项
     * 26. 删除有序数组中的重复项
     */
    public static int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int ans = 1;
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                nums[j + 1] = nums[i];
                j++;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 27. 移除元素，双指针，遍历不等于val的值的元素，则将该元素赋值给
     * j下标的元素（重复的元素），执行完赋值后，则j++,i++;
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int j = 0;
        int ans = len;

        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;

            } else {
                ans--;
            }
        }
        return ans;
    }

    /**
     * 66. 加一, 情况分为9和非9情况，如果为9则进1，否则直接返回
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }


//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("fin ----");
//        super.finalize();
//    }

    /**
     * 股票问题
     * https://leetcode-cn.com/circle/article/qiAgHn/
     */


    /*
    * 【1】当遍历到index遇到1时，说明这个位置有花，那必然从index+2的位置才有可能种花，因此当碰到1时直接跳过下一格。
        【2】当遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，此时只需要判断下一格是不是1即可得出index这一格能不能种花，
    * 如果能种则令n减一，然后这个位置就按照遇到1时处理，即跳两格；如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花（参照【1】），直接跳过3格。
        当n减为0时，说明可以种入n朵花，则可以直接退出遍历返回true；如果遍历结束n没有减到0，说明最多种入的花的数量小于n，则返回false。
    * */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        ConcurrentMap<String, String> a = new ConcurrentHashMap<>();
        System.out.println(a.putIfAbsent("aa", "bb"));
        System.out.println(a.putIfAbsent("aa", "cc"));
    }
}
