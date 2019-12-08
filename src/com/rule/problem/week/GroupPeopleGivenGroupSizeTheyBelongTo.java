package com.rule.problem.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: week 166 1282. Group the People Given the Group Size They Belong To
 * @author: rule
 * @date: 2019-12-08 20:13
 **/
public class GroupPeopleGivenGroupSizeTheyBelongTo {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int[] temp = new int[groupSizes.length];
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> ids = new ArrayList<>();
            if (groupSizes[i] == 1) {
                ids.add(i);
                // 标志位
                temp[i] = 1;
                result.add(ids);
            } else {
                for (int j = 0; j < temp.length; j++) {
                    if (groupSizes[j] == groupSizes[i] && temp[j] == 0 && ids.size() < groupSizes[i]) {
                        ids.add(j);
                        temp[j] = 1;
                    }
                }
                if (ids.size() > 0) {
                    result.add(ids);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] groupSizes = new int[]{1,2,2};
        System.out.println(groupThePeople(groupSizes));
    }
}
