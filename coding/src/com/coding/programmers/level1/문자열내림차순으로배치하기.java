package com.coding.programmers.level1;


import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12917

        // 인풋데이터
        String s = "Zbcdefg";

        // 결과출력
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char[] box = s.toCharArray();
        Arrays.sort(box);

        String reverse =  new String(box);

        for(int i=0; i<s.length(); i++){
            answer.append(reverse.substring(s.length() - i - 1, s.length() - i));
        }

        return answer.toString();
    }
}
