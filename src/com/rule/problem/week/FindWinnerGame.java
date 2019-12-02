package com.rule.problem.week;

/**
 * @description: 165 1275. Find Winner on a Tic Tac Toe Game
 * @author: rule
 * @date: 2019-12-01 14:31
 **/
public class FindWinnerGame {
    public static String tictactoe(int[][] moves) {
        int[][] result = new int[3][3];
        int index = 0;
        for (int i = 0; i < moves.length; i++) {
            result[moves[i][0]][moves[i][1]] = index % 2 == 0 ? 1 : 2;
            index++;
        }
        // A 为1 ，B为2
        if (result[0][0] == 1 && result[1][1] == 1 && result[2][2] == 1) {
            return "A";
        }else if (result[0][0] == 2 && result[1][1] == 2 && result[2][2] == 2) {
            return "B";
        }else if (result[0][2] == 1 && result[1][1] == 1 && result[2][0] == 1) {
            return "A";
        }else if (result[0][2] == 2 && result[1][1] == 2 && result[2][0] == 2) {
            return "B";
        }

        for (int i = 0; i < 3; i++) {
            if (result[i][0] == 1 && result[i][1] == 1 && result[i][2] == 1) {
                return "A";
            }else if (result[i][0] == 2 && result[i][1] == 2 && result[i][2] == 2) {
                return "B";
            }
        }

        for (int i = 0; i < 3; i++) {
            if (result[0][i] == 1 && result[1][i] == 1 && result[2][i] == 1) {
                return "A";
            }else if (result[0][i] == 2 && result[1][i] == 2 && result[2][i] == 2) {
                return "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(moves));
    }
}
