package com.coding.programmers.level2;

public class 덧칠하기 {
    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/161989

        // 인풋데이터
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};

        // 결과출력
        System.out.println(solution(n, m, section));

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int lastNumber = 0;

        for (int i : section) {
            if (i > lastNumber) {
                answer++;
                lastNumber = i + m - 1;
            }
        }

        return answer;
    }
}
