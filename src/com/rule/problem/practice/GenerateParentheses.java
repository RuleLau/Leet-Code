package com.rule.problem.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. Generate Parentheses
 * @author: rule
 * @date: 2019-11-30 14:03
 **/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);

        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}
