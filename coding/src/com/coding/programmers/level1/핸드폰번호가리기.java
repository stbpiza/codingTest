package com.coding.programmers.level1;

public class 핸드폰번호가리기 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12948

        // 인풋데이터
        String phone_number = "01033334444";

        // 결과출력
        System.out.println(solution(phone_number));

    }


    public static String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int length = phone_number.length();

        for(int i=0; i<4; i++){
            answer.insert(0, phone_number.substring(length - i - 1, length - i));
        }

        for(int i=4; i<phone_number.length(); i++) {
            answer.insert(0, "*");
        }

        return answer.toString();
    }


}
