package com.rule.problem.array;

public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = i + 1;  //产生1~n个数
        if(k == 1) return res;  //k==1直接返回
        //k != 1就要翻转k - 1次，每次翻转保留前m个数
        for(int m = 1; m < k; m++)
            reverse(res, m, n - 1);
        return res;
    }
    //翻转数组[i,j]之间的数
    void reverse(int[] res, int i, int j){
        while(i < j){
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
            i++;
            j--;
        }
    }

}
