package com.rule.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui-1
 * @version 1.0.0
 * @description 17. Letter Combinations of a Phone Number
 * @date 11/26/2019 3:25 PM
 */
public class LetterCombinationsPhoneNumber {
    private static final String[] nums = new String[10];

    static {
        nums[2] = "abc";
        nums[3] = "def";
        nums[4] = "ghi";
        nums[5] = "jkl";
        nums[6] = "mno";
        nums[7] = "pqrs";
        nums[8] = "tuv";
        nums[9] = "wxyz";
    }
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        packData("", digits);
        return result;
    }

    private void packData(String com, String digits) {
        if (digits.length() == 0) {
            result.add(com);
        }else {
            String digit = digits.substring(0, 1);
            String letters = nums[Integer.parseInt(digit)];
            for (int i = 0; i < letters.length(); i++) {
                String letter = nums[Integer.parseInt(digit)].substring(i, i + 1);
                packData(com + letter, digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        System.out.println(l.letterCombinations("234"));
    }

}
