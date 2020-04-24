package com.rule.problem.interview.string;

public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while(i < j)
        {
            if(c[i] != c[j])    return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        int len = s.length();
        //左指针
        int i = 0;
        //右指针
        int j = len - 1;
        //代表尝试跳过字符的次数，值为0表示没有跳过，为1表示尝试跳过左边指针指向的字符，为2表示尝试跳过右边指针指向的字符
        int index = 0;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                //尝试跳过左边指针指向的字符,继续比较
                if (index == 0) {
                    i++;//跳过左边指针，继续下次比较
                    index++;
                    continue;
                }
                //说明尝试跳过左边指针指向的字符失败，先还原左边指针指向的字符，尝试跳过右边指针指向的字符
                if (index == 1) {
                    i--;//还原左边指针
                    j--;//跳过右边指针
                    index++;
                    continue;
                }
                //如果经过两次尝试之后两边字符还不相等，则返回false
                if (index > 1) {
                    return false;
                }

            }
            //相等，则两个指针向中心靠拢，继续比较
            i++;
            j--;
        }

        return true;
    }

    /**
     * 009. 判断一个整数是否是回文数
     */
    public static boolean isPalindrome3(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-') {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome3(121));
    }
}
