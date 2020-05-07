package com.rule.problem.interview.string;

public class ReverseWords {

    /**
     * 151. 翻转字符串里的单词
     */
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
            }
            if (s.charAt(i) == ' ' || i == 0){
                res.append(temp.reverse());
                int l = res.length();
                if (res.charAt(l - 1) != ' ') {
                    res.append(' ');
                }
                temp.setLength(0);
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("aaa aa a aaa      a"));
    }
}
