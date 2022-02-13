package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/42586

        // 인풋데이터
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        // 결과출력
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }


    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int size = progresses.length;
        int[] days = new int[size];
        ArrayList answer2 = new ArrayList();

        for(int i=0; i<size; i++) {
            double cal = (double) (100 - progresses[i])/speeds[i];
            int day = (int) Math.ceil(cal);
            days[i] = day;
        }

        System.out.println(Arrays.toString(days));

        int now = 1;
        for(int i=0; i<size; i++) {
            if(i==0) {
                now = days[0];
                answer2.add(1);
            } else if (now >= days[i]) {
                answer2.set(answer2.size()-1, (int)answer2.get(answer2.size()-1)+1 );
            } else {
                answer2.add(1);
                now = days[i];
            }
        }
        answer = answer2.stream().mapToInt(i-> (int) i).toArray();
        return answer;
    }
}
