package com.coding.programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/76502

        // 인풋데이터
        String s = "([{])}";

        // 결과출력
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String now = s.substring(i) + s.substring(0, i);
            Stack<String> stackStr = new Stack<>();
            boolean isOk = true;
            for (int j = 0; j < now.length(); j++) {
                String temp = now.substring(j, j + 1);
                if (temp.equals("(") || temp.equals("{") || temp.equals("[")) {
                    stackStr.push(temp);
                } else {
                    if (stackStr.isEmpty()) {
                        isOk = false;
                        break;
                    }
                    String popStr = stackStr.pop();
                    if (temp.equals(")") && !popStr.equals("(")) {
                        isOk = false;
                        break;
                    } else if (temp.equals("}") && !popStr.equals("{")) {
                        isOk = false;
                        break;
                    } else if (temp.equals("]") && !popStr.equals("[")) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk && stackStr.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
