package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {
    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/17682

        // 인풋데이터
        String dartResult = "1S2D*3T";

        // 결과출력
        System.out.println(solution(dartResult));

    }

    public static int solution(String dartResult) {
        int answer = 0;
        List<Integer> box = new ArrayList<>();

        int index = 0;
        String midString = "";
        for(int i=0; i<dartResult.length(); i++) {
            String s = dartResult.substring(i, i+1);
            if(s.equals("S")) {
                box.add(Integer.parseInt(midString));
                index++;
                midString = "";
            } else if (s.equals("D")) {
                box.add(Integer.parseInt(midString)*Integer.parseInt(midString));
                index++;
                midString = "";
            } else if (s.equals("T")) {
                box.add(Integer.parseInt(midString)*Integer.parseInt(midString)*Integer.parseInt(midString));
                index++;
                midString = "";
            } else if (s.equals("*")) {
                box.set(index-1, box.get(index-1)*2);
                if(index != 1) {
                    box.set(index-2, box.get(index-2)*2);
                }
            } else if (s.equals("#")) {
                box.set(index-1, box.get(index-1)*(-1));
            } else {
                midString = midString + s;
            }
        }

        for (Integer integer : box) {
            answer += integer;
            System.out.println("integer = " + integer);
        }


        return answer;
    }

}
