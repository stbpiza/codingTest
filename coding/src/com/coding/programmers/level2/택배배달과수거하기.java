package com.coding.programmers.level2;

public class 택배배달과수거하기 {
    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/150369

        // 인풋데이터
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        // 결과출력
        System.out.println(solution(cap, n, deliveries, pickups));

    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliveryBox = 0;
        int pickupBox = 0;

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (deliveryBox < deliveries[i] || pickupBox < pickups[i]) {
                deliveryBox += cap;
                pickupBox += cap;
                count++;
            }
            deliveryBox -= deliveries[i];
            pickupBox -= pickups[i];
            answer += (long) (i + 1) * 2 * count;
        }


        return answer;
    }
}
