package com.coding.programmers.level3;


public class 정수삼각형 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/43105

        // 인풋데이터
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        // 결과출력
        System.out.println(solution(triangle));

    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                System.out.println("i = " + i + " " + j);
                if (j == 0 ) {
                    triangle[i][j] += triangle[i-1][j];
                } else if ( j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                if (triangle[i][j] > answer) answer = triangle[i][j];
            }
        }
        return answer;
    }
}
