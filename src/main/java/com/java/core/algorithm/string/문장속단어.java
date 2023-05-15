package com.java.core.algorithm.string;

import java.util.Scanner;

public class 문장속단어 {

    /**
     * [ 설명 ]
     * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
     * 문장속의 각 단어는 공백으로 구분됩니다.
     *
     * [ 입력 ]
     * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
     * 문장은 영어 알파벳으로만 구성되어 있습니다.
     *
     * [ 출력 ]
     * 첫 줄에 가장 긴 단어를 출력한다.
     * 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
     * 단어를 답으로 합니다.
     *
     * [ 예시 입력 1 ]
     * it is time to study
     *
     * [ 예시 출력 1 ]
     * study
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 한줄 짜리 데이터를 입력받기 위해 next() 대신 nextLine()
        String str = in.nextLine();

        String result = splitSolution(str);
        String result2 = indexOfSolution(str);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);

    }

    private static String indexOfSolution(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE;
        int pos; // 위치 값

        // indexOf() 로 찾으려는 값으 발견못하면 -1 을 return 한다.
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > m) {
            answer = str;
        }

        return answer;

    }


    private static String splitSolution(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        // 지인철
//        String[] arr = str.split(" ");
//        for (String s : arr) {
//            System.out.println("s = " + s);
//            if (answer.length() < s.length()) {
//                answer = s;
//            }
//        }
//
        return answer;
    }
}
