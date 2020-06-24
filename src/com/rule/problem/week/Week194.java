package com.rule.problem.week;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-06-24 07:49
 **/
public class Week194 {

    /**
     * 1486. 数组异或操作
     */
    public static int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int[] nums = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
            res = res ^ nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
        return res;
    }


    /**
     * 1487. 保证文件名唯一
     */
    public static String[] getFolderNames(String[] names) {
        if (names == null || names.length == 0) {
            return null;
        }
        // 结果字符串数组
        String[] re = new String[names.length];
        // 保存文件出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<names.length; i++) {
            // 如果没有出现过，直接赋值即可
            if (!map.containsKey(names[i])) {
                re[i] = names[i];
                map.put(names[i], 1);
            } else {
                // 如果出现过，先取出之前出现的次数，再判断后序的有没有出现过
                int count=map.get(names[i]);
                while (map.containsKey(names[i] + "(" + count + ")")) {
                    count++;
                }
                // 细节：记得更新
                map.put(names[i] + "(" + count + ")", 1);
                map.put(names[i], map.get(names[i])+1);
                // 本次的结果
                re[i] = names[i] + "(" + count + ")";
            }
        }
        return re;

    }

    public static void main(String[] args) {
        //xorOperation(5, 0  );
        getFolderNames(new String[]{"gta","gta(1)","gta","avalon"});
    }
}
