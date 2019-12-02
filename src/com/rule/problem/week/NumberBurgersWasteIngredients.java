package com.rule.problem.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 165 1276. Number of Burgers with No Waste of Ingredients
 * @author: rule
 * @date: 2019-12-01 15:09
 **/
public class NumberBurgersWasteIngredients {
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            result.add(0);
            result.add(0);
            return result;
        }
        if (tomatoSlices % 2 != 0 || cheeseSlices >= tomatoSlices) {
            return result;
        }
        int small = tomatoSlices / 2;
        int smCh = small;
        int jum = 0;
        if (smCh < cheeseSlices) {
            return result;
        }
        while (smCh > cheeseSlices) {
            small = small - 2;
            jum++;
            smCh = smCh - 1;
            if (small < 0){
                return result;
            }
        }
        result.add(jum);
        result.add(small);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfBurgers(16 ,7));
    }
}
