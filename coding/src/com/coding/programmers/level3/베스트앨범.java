package com.coding.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42579

        // 인풋데이터
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 결과출력
        int[] solution = solution(genres, plays);
        for (int i : solution) {
            System.out.println(i);
        }

    }

    public static int[] solution(String[] genres, int[] plays) {

        List<Integer> answerArrayList = new ArrayList<>();

        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<IndexAndPlays>> genresMap = new HashMap<>();

        for (int i=0; i< genres.length; i++) {
            if (totalPlays.containsKey(genres[i])) {
                totalPlays.put(genres[i], totalPlays.get(genres[i]) + plays[i]);
                genresMap.get(genres[i]).add(new IndexAndPlays(i, plays[i]));
            } else {
                totalPlays.put(genres[i], plays[i]);
                List<IndexAndPlays> newList = new ArrayList<>();
                newList.add(new IndexAndPlays(i, plays[i]));
                genresMap.put(genres[i], newList);
            }

            System.out.println("i = " + i);
            System.out.println("genres = " + genres[i]);
            System.out.println("plays = " + plays[i]);
            System.out.println("totalPlays = " + totalPlays.get(genres[i]));
            for (IndexAndPlays indexAndPlays : genresMap.get(genres[i])) {
                System.out.println("indexAndPlays.index = " + indexAndPlays.index);
                System.out.println("indexAndPlays.plays = " + indexAndPlays.plays);
            }
        }

        List<String> keySet = new ArrayList<>(totalPlays.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return totalPlays.get(o2).compareTo(totalPlays.get(o1));
            }
        });

        for (String s : keySet) {
            System.out.println("s = " + s);
            List<IndexAndPlays> indexAndPlays = genresMap.get(s);

            Collections.sort(indexAndPlays);

            int count = 1;
            for (IndexAndPlays indexAndPlay : indexAndPlays) {
                System.out.println("indexAndPlay.index = " + indexAndPlay.index);
                System.out.println("indexAndPlay.plays = " + indexAndPlay.plays);
                answerArrayList.add(indexAndPlay.index);
                count++;
                if (count == 3) break;
            }
        }


        return answerArrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class IndexAndPlays implements Comparable<IndexAndPlays> {
        int index;
        int plays;

        @Override
        public int compareTo(IndexAndPlays o) {
            return Integer.compare(o.plays, this.plays);
        }

        public IndexAndPlays(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
