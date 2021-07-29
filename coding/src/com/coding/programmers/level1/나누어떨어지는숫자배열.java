package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12910

        // 인풋데이터
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        // 결과출력
        System.out.println(Arrays.toString(solution(arr, divisor)));

    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> box = new ArrayList<>();

        for (int i : arr) {
            if(i%divisor==0) {
                box.add(i);
            }
        }
        if(box.isEmpty()) {
            box.add(-1);
        }

        Collections.sort(box);
        answer = box.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
