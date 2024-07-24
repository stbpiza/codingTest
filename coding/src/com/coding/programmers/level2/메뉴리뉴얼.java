package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/72411

        // 인풋데이터
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // 결과출력
        String[] solution = solution(orders, course);
        for (String i : solution) {
            System.out.println(i);
        }

    }

    public static String[] solution(String[] orders, int[] course) {

        List<String> answerArray = new ArrayList<>();

        for (int count : course) {
            Map<String, Integer> orderMap = new HashMap<>();
            for (String order : orders) {
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                boolean[] visited = new boolean[charArray.length];

                orderCombination(charArray, visited, 0, count, orderMap);
            }

            int max = 0;
            for (String s : orderMap.keySet()) {
                max = Math.max(max, orderMap.get(s));
            }
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                    if (entry.getValue() == max) answerArray.add(entry.getKey());
                }
            }
        }

        Collections.sort(answerArray);

        String[] answer = answerArray.toArray(new String[0]);


        return answer;
    }

    static void orderCombination(char[] arr, boolean[] visited, int depth, int r, Map<String, Integer> orderMap) {
        if(r == 0) {
            print(arr, visited, orderMap);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            orderCombination(arr, visited, depth + 1, r - 1, orderMap);

            visited[depth] = false;
            orderCombination(arr, visited, depth + 1, r, orderMap);
        }
    }

    static void print(char[] arr, boolean[] visited, Map<String, Integer> orderMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(visited[i])
                stringBuilder.append(arr[i]);
        }
        String order = stringBuilder.toString();
        if (orderMap.containsKey(order)) {
            orderMap.put(order, orderMap.get(order)+1);
        } else {
            orderMap.put(order, 1);
        }
    }
}
