package com.coding.programmers.level1;

public class 이상한문자만들기 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12930

        // 인풋데이터
        String s = "try hello world";

        // 결과출력
        System.out.println(solution(s));

    }
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean even = true;
        for (int i=0; i<s.length(); i++) {
            String a = s.substring(i,i+1);
            if(a.equals(" ")){
                answer.append(" ");
                even = true;
            } else {
                if(even){
                    answer.append(a.toUpperCase());
                    even = false;
                } else {
                    answer.append(a.toLowerCase());
                    even = true;
                }
            }
        }

        return answer.toString();
    }

}
