package com.coding.programmers.level2;

public class 혼자서하는틱택토 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/160585

        // 인풋데이터
        String[] board = {"OOO", "...", "XXX"};

        // 결과출력
        System.out.println(solution(board));

    }

    public static int solution(String[] board) {

        char[][] gameResult = new char[3][3];
        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameResult[i][j] = board[i].charAt(j);
                if (gameResult[i][j] == 'O') {
                    oCount++;
                } else if (gameResult[i][j] == 'X') {
                    xCount++;
                }
            }
        }

        if (xCount > oCount || oCount > xCount + 1) return 0;

        boolean oWin = checkWin('O', gameResult);
        boolean xWin = checkWin('X', gameResult);

        if (oWin && xWin) return 0;
        if (oWin && oCount != xCount + 1) return 0;
        if (xWin && oCount != xCount) return 0;


        return 1;
    }

    public static boolean checkWin(char ox, char[][] gameResult) {
        for (int i = 0; i < 3; i++) {
            if (gameResult[i][0] == ox && gameResult[i][1] == ox && gameResult[i][2] == ox) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameResult[0][i] == ox && gameResult[1][i] == ox && gameResult[2][i] == ox) {
                return true;
            }
        }
        if (gameResult[0][0] == ox && gameResult[1][1] == ox && gameResult[2][2] == ox) {
            return true;
        }
        if (gameResult[2][0] == ox && gameResult[1][1] == ox && gameResult[0][2] == ox) {
            return true;
        }

        return false;
    }

}
