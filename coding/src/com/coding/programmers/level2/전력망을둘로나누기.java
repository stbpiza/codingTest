package com.coding.programmers.level2;

import java.util.ArrayList;

public class 전력망을둘로나누기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42861

        // 인풋데이터
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        // 결과출력
        System.out.println(solution(n, wires));

    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        // 노드 개수만큼 ArrayList 생성
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 구조
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            // 해당 간선을 그래프에서 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            // 임의의 시작점에서 dfs 탐색
            int cnt = dfs(1, visited, graph);

            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);

            // 그래프에 다시 간선 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return answer;
    }


    public static int dfs(int v, boolean[] visited, ArrayList<Integer>[] graph) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited, graph);
            }
        }

        return cnt;
    }
}
