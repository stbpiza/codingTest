package com.coding.programmers.level0;

public class 문자열겹쳐쓰기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/250137

        // 인풋데이터
        String myString = "He11oWor1d";
        String overwriteString = "lloWorl";
        int s = 2;

        // 결과출력
        System.out.println(solution(myString, overwriteString, s));

    }

    public static String solution(String my_string, String overwrite_string, int s) {
        String answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());
        return answer;
    }
}
