package com.java.core.algorithm.string;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {

    /**
     * 4. 단어 뒤집기
     *
     * [ 설명 ]
     * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     *
     *
     * [ 입력 ]
     * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다.
     * 단어는 영어 알파벳으로만 구성되어 있습니다.
     *
     *
     * [ 출력 ]
     * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     *
     * [ 예시 입력 1 ]
     * 3
     * good
     * Time
     * Big
     *
     * [ 예시 출력 1 ]
     * doog
     * emiT
     * giB
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();

        String[] data = new String[count];

        for (int i = 0; i < count; i++) {
             data[i] = in.next();
        }

        String[] icjiAnswer = icjiSolution(data);
        for (String s : icjiAnswer) {
            System.out.println("icji = "  + s);
        }

        ArrayList<String> solution = solution(count, data);
        for (String s : solution) {
            System.out.println("s = " + s);
        }


    }

    private static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            // solution (1)
//            String tmp = new StringBuilder(x).reverse().toString();

            // solution (2)
            char[] c = x.toCharArray();

            int lt = 0; // 왼쪽 문자
            int rt = c.length - 1; // 오른쪽 문자

            while (lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }

            String tmp = String.valueOf(c);

            // common
            answer.add(tmp);
        }
        return answer;
    }

    private static String[] icjiSolution(String[] data) {
        StringBuilder builder = new StringBuilder();

        String[] answer = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            String reverse = builder.reverse().toString();
            answer[i] = reverse;
            builder.delete(i, answer[i].length());
        }

        return answer;
    }


}
