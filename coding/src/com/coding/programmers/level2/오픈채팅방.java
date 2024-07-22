package com.coding.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42888

        // 인풋데이터
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        // 결과출력
        String[] solution = solution(record);
        for (String i : solution) {
            System.out.println(i);
        }

    }

    public static String[] solution(String[] record) {
        List<String> resultOrder = new ArrayList<>();
        Map<String, String> nickNameMap = new HashMap<>();
        for (String s : record) {
            recordDto recordDto = recordParser(s);

            if (!nickNameMap.containsKey(recordDto.uid)) {
                nickNameMap.put(recordDto.uid, recordDto.nickname);
            }

            if (recordDto.action.equals("Enter")) {
                resultOrder.add(recordDto.uid + " 들어왔습니다.");
                nickNameMap.put(recordDto.uid, recordDto.nickname);
            } else if (recordDto.action.equals("Leave")) {
                resultOrder.add(recordDto.uid + " 나갔습니다.");
            } else {
                nickNameMap.put(recordDto.uid, recordDto.nickname);
            }
        }

        String[] answer = new String[resultOrder.size()];
        for (int i=0; i<resultOrder.size(); i++) {
            String[] split = resultOrder.get(i).split(" ");
            answer[i] = nickNameMap.get(split[0]) + "님이 " + split[1];
        }

        return answer;
    }

    public static recordDto recordParser(String record) {
        String[] split = record.split(" ");

        if (split.length == 3) {
            return new recordDto(split[0], split[1], split[2]);
        } else {
            return new recordDto(split[0], split[1], null);
        }
    }

    public static class recordDto {
        String action;
        String uid;
        String nickname;

        public recordDto(String action, String uid, String nickname) {
            this.action = action;
            this.uid = uid;
            this.nickname = nickname;
        }
    }

}
