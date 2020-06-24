package com.rule.problem.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<String, Integer> map = new HashMap<>();
        int len = names.length;
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
            }else {
                int k = 1;
                while (map.containsKey(name)) {
                    k++;
                    name += "(" + k + ")";
                }
                map.put(name, 1);
                res[i] = name;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;

    }

    public static void main(String[] args) {
        //xorOperation(5, 0  );
        getFolderNames(new String[]{"gta","gta(1)","gta","avalon"});
    }
}
