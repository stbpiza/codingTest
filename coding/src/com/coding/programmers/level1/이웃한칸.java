package com.coding.programmers.level1;

public class 이웃한칸 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/250125

        // 인풋데이터
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"},
                           {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 2;
        int w = 2;
        // 결과출력
        System.out.println(solution(board, h, w));

    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        if (h != 0) {
            if (board[h][w].equals(board[h - 1][w])) {
                answer++;
            }
        }
        if (h != board.length - 1) {
            if (board[h][w].equals(board[h + 1][w])) {
                answer++;
            }
        }
        if (w != 0) {
            if (board[h][w].equals(board[h][w - 1])) {
                answer++;
            }
        }
        if (w != board[0].length - 1) {
            if (board[h][w].equals(board[h][w + 1])) {
                answer++;
            }
        }
        return answer;
    }

}
