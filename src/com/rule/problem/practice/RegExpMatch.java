package com.rule.problem.practice;

/**
 * @description: 正则表达式匹配 10. Regular Expression Matching
 * @author: rule
 * @date: 2019-10-13 00:31
 **/
public class RegExpMatch {

    private static final char REPEAT_MANY_TIMES = '*';
    private static final char ANY_SINGLE_CHAR= '.';

    public static boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if ((!p.contains(REPEAT_MANY_TIMES + "")) && pl != sl) {
            return false;
        }else if (s.equals(p)) {
            return true;
        }
        int sIdx = 0;
        int pIdx = 0;
        char last;
        while (sIdx < sl && pIdx < pl) {
            if (s.charAt(sIdx) == p.charAt(pIdx)
                || ANY_SINGLE_CHAR == p.charAt(pIdx)) {
                sIdx++;
                pIdx++;
            }else if (s.charAt(sIdx) != p.charAt(pIdx)
                    && pIdx + 1 < pl && REPEAT_MANY_TIMES == p.charAt(pIdx + 1)) {
                pIdx+=2;
            }else if (REPEAT_MANY_TIMES == p.charAt(pIdx)){
                if (pIdx == 0) {
                    pIdx++;
                }else {
                    // 记录上一个元素
                    //"aa"
                    //"a*c*a"
                    last = p.charAt(pIdx - 1);
                    if (ANY_SINGLE_CHAR == last) {
                        // 计算p中下一个字符
                        if (pIdx + 1 == pl) {
                            return true;
                        }else {
                            // abcd
                            //.*e
                            while (sIdx < sl) {
                                if (s.charAt(sIdx) != p.charAt(pIdx + 1)) {
                                    sIdx++;
                                }
                            }
                            if(sIdx == sl){
                                // 查询到最后都没有匹配上
                                return false;
                            }
                        }
                    }else {
                        // aaa
                        // a*e
                        while (sIdx < sl) {
                            if (pIdx == pl - 1){
                                if (s.charAt(sIdx) != last) {
                                    return false;
                                }else {
                                    sIdx++;
                                }
                            }else {
                                if (s.charAt(sIdx) == last) {
                                    if (s.charAt(sIdx) != p.charAt(pIdx + 1)) {
                                        sIdx++;
                                        break;
                                    }else {
                                        pIdx++;
                                    }
                                }
                            }
                        }
                        if (sIdx == sl && pIdx < pl - 1) {
                            return false;
                        }else if (sIdx == sl && pIdx == pl - 1) {
                            return true;
                        }
                    }
                    pIdx++;
                }
            }else {
                return false;
            }
        }
        if (sIdx < sl && pIdx <= pl) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*c*a";
        System.out.println(isMatch(s, p));
    }
}
