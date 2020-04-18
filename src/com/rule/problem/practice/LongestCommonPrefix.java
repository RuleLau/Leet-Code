package com.rule.problem.practice;


/**
 * @description: 14. Longest Common Prefix
 * @author: rule
 * @date: 2019-11-18 21:56
 **/
public class LongestCommonPrefix {

    /**
     * O(m*n
     * )
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        String str0 = strs[0];
        if(str0.length()==0) {
            return "";
        }
        int rightMostIndex = str0.length()-1;
        for(int k=1;k<strs.length;k++){
            for(int i=0;i<=rightMostIndex;i++){
                if((i>strs[k].length()-1)||strs[k].charAt(i)!=str0.charAt(i)){
                    rightMostIndex=i-1;
                }
            }
        }
        return rightMostIndex>=0?str0.substring(0,rightMostIndex+1):"";
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs1 = new String[]{"dog", "racecar", "car"};
        String[] strs2 = new String[]{""};
        String[] strs3 = new String[]{"a"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }

}
