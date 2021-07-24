package com.coding.programmers;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12932

        // 인풋데이터
        Long n = 12345L;

        // 결과출력
        System.out.println(Arrays.toString(solution(n)));

    }

    public static int[] solution(long n) {

        String nText = Long.toString(n); // length, 한글자씩 자르기 위해 스트링으로 변환
        int length = nText.length(); // length 쓰는 곳이 많아서 변수에 담음
        int[] answer = new int[length]; // 길이에 맞게 배열생성

        for(int i=0; i<length; i++) { // 한 글자씩 배열에 담기
            answer[i] = Integer.parseInt(nText.substring(length-i-1,length-i)); // 뒤에서부터 한 글자씩
        }

        return answer;
    }
}
