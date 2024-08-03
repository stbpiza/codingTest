package com.coding.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 길찾기게임 {

    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/42892

        // 인풋데이터
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};


        // 결과출력
        int[][] solution = solution(nodeinfo);
        for (int[] i : solution) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] solution(int[][] nodeinfo) {

        List<Node> nodes = new ArrayList<>();
        Node root;
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(nodes);
        root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            connectNode(root, nodes.get(i));
        }
        preOrder(root, pre);
        postOrder(root, post);
        int[][] answer = new int[2][];
        answer[0] = pre.stream().mapToInt(i -> i).toArray();
        answer[1] = post.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    static void preOrder(Node now, List<Integer> pre) {
        if (now != null) {
            pre.add(now.num);
            if (now.left != null) {
                preOrder(now.left, pre);
            }
            if (now.right != null) {
                preOrder(now.right, pre);
            }
        }
    }

    static void postOrder(Node now, List<Integer> post) {
        if (now != null) {
            if (now.left != null) {
                postOrder(now.left, post);
            }
            if (now.right != null) {
                postOrder(now.right, post);
            }
            post.add(now.num);
        }
    }

    static void connectNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }

    static class Node implements Comparable<Node> {
        Node left;
        Node right;
        int num;
        int x;
        int y;

        Node(int num, int x, int y) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return o.y - this.y;
        }
    }
}
