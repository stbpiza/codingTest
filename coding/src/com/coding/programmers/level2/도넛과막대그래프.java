package com.coding.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 도넛과막대그래프 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/258711

        // 인풋데이터
        int[][] edges = {{2,3},{4,3},{1,1},{2,1}};

        // 결과출력
        int[] solution = solution(edges);
        for (int i : solution) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        for (int node : out.keySet()) {
            if (out.get(node) > 1) {
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3] += 1;
                }
            }
        }

        for (int node : in.keySet()) {
            if (!out.containsKey(node)) {
                answer[2] += 1;
            }
        }
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}
