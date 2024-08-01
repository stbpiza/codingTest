package com.coding.programmers.level2;

public class 예상대진표 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/12985

        // 인풋데이터
        int n = 8;
        int a = 4;
        int b = 7;

        // 결과출력
        System.out.println(solution(n, a, b));

    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            a = a % 2 == 0 ? (a + 1) / 2 : a / 2;
            b = b % 2 == 0 ? (b + 1) / 2 : b / 2;
            if (a == b) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
