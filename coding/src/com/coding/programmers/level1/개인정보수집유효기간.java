package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/150370

        // 인풋데이터
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        // 결과출력
        int[] result = solution(today, terms, privacies);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = convertTerms(terms);

        int todayDate = convertDate(today);

        int i = 1;
        for (String privacy : privacies) {
            String[] split = privacy.split(" ");
            int privacyDate = convertDate(split[0]);
            int term = termMap.get(split[1]);
            System.out.println(privacyDate + " + " + term + " = " + (privacyDate + term) + " " + todayDate);
            if (privacyDate + term <= todayDate) {
                answer.add(i);
            }
            i++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static Map<String, Integer> convertTerms(String[] terms) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
            System.out.println("term = " + split[0] + " " + Integer.parseInt(split[1]) * 28);
        }
        return termMap;
    }

    public static Integer convertDate(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int result = year * 28 * 12 + month * 28 + day;
        System.out.println("date = " + year + " " + month + " " + day);
        System.out.println("convert = " + result);
        return result;
    }
}
