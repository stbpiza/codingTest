package com.coding.programmers.level1;

public class 문자열을정수로바꾸기 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12925

        // 인풋데이터
        String s = "-1234";

        // 결과출력
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        int answer = Integer.parseInt(s);

        return answer;
    }

}
