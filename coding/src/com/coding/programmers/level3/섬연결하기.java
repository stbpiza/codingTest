package com.coding.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42861

        // 인풋데이터
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        // 결과출력
        System.out.println(solution(n, costs));

    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        for (int[] cost : costs) {
            if (findParent(parent, cost[0]) != findParent(parent, cost[1])) {
                answer += cost[2];
                union(parent, cost[0], cost[1]);
            }
        }

        return answer;
    }


    public static int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        return findParent(parent, parent[node]);
    }
    public static void union(int[] parent, int node1, int node2) {
        int p1 = findParent(parent, node1);
        int p2 = findParent(parent, node2);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}
