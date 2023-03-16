package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 호텔대실 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/155651

        // 인풋데이터
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        // 결과출력
        System.out.println(solution(book_time));

    }

    public static int solution(String[][] book_time) {
        int answer = 0;

        final int MAX = 24*60 + 10;

        int[] rooms = new int[MAX];

        for (String[] strings : book_time) {
            int inTime = change(strings[0]);
            int outTime = change(strings[1]);
            rooms[inTime] += 1;
            rooms[outTime+10] -= 1;
        }

        for (int i=1; i<MAX; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    public static int change(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3));
        return hour*60 + minute;
    }

}
