package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 붕대감기 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/250137

        // 인풋데이터
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        // 결과출력
        System.out.println(solution(bandage, health, attacks));

    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int total = attacks[attacks.length - 1][0];
        Map<Integer, Integer> attackTime = new HashMap<>();
        for (int i=0; i<attacks.length; i++) {
            attackTime.put(attacks[i][0], attacks[i][1]);
        }
        int nowHealth = health;
        int continueCount = 0;
        for (int i=1; i<=total; i++) {
            if (attackTime.containsKey(i)) {
                nowHealth -= attackTime.get(i);
                continueCount = 0;
            } else {
                nowHealth += bandage[1];
                continueCount++;
                if (continueCount == bandage[0]) {
                    nowHealth += bandage[2];
                    continueCount = 0;
                }
                if (nowHealth > health) nowHealth = health;
            }
            if (nowHealth <= 0) {
                answer = -1;
                break;
            }
        }
        return answer == -1 ? answer : nowHealth;
    }
}
