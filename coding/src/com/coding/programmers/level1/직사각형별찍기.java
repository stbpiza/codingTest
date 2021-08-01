package com.coding.programmers.level1;

import java.util.Scanner;

public class 직사각형별찍기 {

    public static void main(String[] args) {

        // https://programmers.co.kr/learn/courses/30/lessons/12969

        // 인풋데이터
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder s = new StringBuilder();

        for (int i=0; i<a; i++) {
            s.append("*");
        }


        // 결과출력
        for (int i=0; i<b; i++) {
            System.out.println(s.toString());
        }
    }


}
