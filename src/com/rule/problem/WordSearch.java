package com.rule.problem;

/**
 * @description: 79. Word Search
 * @author: rule
 * @date: 2019-12-29 14:44
 **/
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int length = word.length();
        int lastChar = word.charAt(length - 1);
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                while (board[i][j] == word.charAt(index)) {
                    //上边界



                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
