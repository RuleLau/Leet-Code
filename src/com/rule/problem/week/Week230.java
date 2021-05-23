package com.rule.problem.week;

import java.util.Arrays;
import java.util.List;

public class Week230 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type") && ruleValue.equals(item.get(0))) {
                ans++;
            } else if (ruleKey.equals("color") && ruleValue.equals(item.get(1))) {
                ans++;
            } else if (ruleKey.equals("name") && ruleValue.equals(item.get(2))) {
                ans++;
            }
        }
        return ans;
    }

    int ans = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // n=1, m>=0
        for (int baseCost : baseCosts) {
            dfs(0, toppingCosts, baseCost, target);
        }
        return ans;
    }

    private void dfs(int index, int[] toppingCosts, int cost, int target) {

        if (Math.abs(target - cost) < Math.abs(target - ans) || Math.abs(target - cost) == Math.abs(target - ans) && cost < ans) {
            ans = cost;
        }
        if (cost >= target || index == toppingCosts.length) {
            return;
        }
        for (int i = index; i < toppingCosts.length; i++) {
            dfs(i + 1, toppingCosts, toppingCosts[i] + cost, target);
            dfs(i + 1, toppingCosts, 2 * toppingCosts[i] + cost, target);
        }
    }

    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts) {
            dfs1(0, base, target, toppingCosts);
        }
        return ans;
    }

    private void dfs1(int cur, int cost, int target, int[] toppingCosts) {
        if (Math.abs(target - cost) < Math.abs(target - ans) || Math.abs(target - cost) == Math.abs(target - ans) && cost < ans) {
            ans = cost;
        }
        if (cost >= target || cur == toppingCosts.length) {
            return;
        }
        dfs1(cur + 1, cost, target, toppingCosts);
        dfs1(cur + 1, cost + toppingCosts[cur], target, toppingCosts);
        dfs1(cur + 1, cost + 2 * toppingCosts[cur], target, toppingCosts);
    }

}
