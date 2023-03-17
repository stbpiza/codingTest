package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/138476

        // 인풋데이터
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        // 결과출력
        System.out.println(solution(k, tangerine));

    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int t : tangerine) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t)+1);
            } else {
                map.put(t, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((t, count) -> count.getValue().compareTo(t.getValue()));

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            count += entry.getValue();
            answer++;
            if (count >= k) {
                break;
            }
        }

        return answer;
    }

}
