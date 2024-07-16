package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 주식가격 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42584

        // 인풋데이터
        int[] s = {1, 2, 3, 2, 3};

        // 결과출력
        int[] solution = solution(s);
        for (int i : solution) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            answer[pop] = prices.length - pop - 1;
        }
        return answer;
    }
}
