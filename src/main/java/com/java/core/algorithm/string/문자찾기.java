package com.java.core.algorithm.string;

import java.util.Scanner;

public class 문자찾기 {

    /**
     * [ 1. 문자 찾기]
     *
     * [ 설명 ]
     * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     *
     * [ 입력 ]
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * [ 출력 ]
     * 첫 줄에 해당 문자의 개수를 출력한다.
     *
     * ---------------------------------
     * [ 예시 입력 1 ]
     * Computercooler
     * c
     *
     * [ 예시 출력 1 ]
     * 2
     * ---------------------------------
     */



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.next(); // 문자열을 읽어 들인다.
        char c = in.next().charAt(0); // 문자열 중 문자 1개만 가져오기

        System.out.println(str +" || "+ c);

        int result = solution(str, c);


        System.out.println("result = " + result);
    }

    public static int solution(String str, char c) {
        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        System.out.println("str = " + str);
        System.out.println("c = " + c);

//        for (int i = 0; i < str.length(); i++) {
//            char c1 = str.charAt(i);
//            if (c == c1) {
//                answer += 1;
//            }
//        }

        for (char c1 : str.toCharArray()) {
            if (c == c1) {
                answer += 1;
            }
        }
        return answer;
    }

}
