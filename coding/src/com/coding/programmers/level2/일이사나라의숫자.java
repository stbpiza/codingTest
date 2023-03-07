package com.coding.programmers.level2;

public class 일이사나라의숫자 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12899

        // 인풋데이터
        int n = 7;

        // 결과출력
        System.out.println(solution(n));

    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n!=0) {
            int remainder = n%3;
            n = n/3;
            if (remainder == 0) {
                answer.insert(0, 4);
                n--;
            } else {
                answer.insert(0, remainder);
            }
        }

        return answer.toString();
    }



}
