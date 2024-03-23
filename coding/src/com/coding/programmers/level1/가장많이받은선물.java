package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 가장많이받은선물 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/258712

        // 인풋데이터
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                            "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        // 결과출력
        System.out.println(solution(friends, gifts));

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] history = new int[friends.length][friends.length];
        Map<String, Integer> giftIndex = new HashMap<>();

        List<String> friendList = List.of(friends);

        for (String name : friendList) {
            giftIndex.put(name, 0);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            history[friendList.indexOf(split[0])][friendList.indexOf(split[1])]++;
            giftIndex.put(split[0], giftIndex.get(split[0]) + 1);
            giftIndex.put(split[1], giftIndex.get(split[1]) - 1);
        }

        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            int midAnswer = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j ) continue;
                if (history[i][j] > history[j][i]) {
                    midAnswer++;
                } else if (history[i][j] == history[j][i] && giftIndex.get(name) > giftIndex.get(friends[j])) {
                    midAnswer++;
                }
            }
            if (answer < midAnswer) {
                answer = midAnswer;
            }
        }

        return answer;
    }
}
