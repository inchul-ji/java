package com.java.core.algorithm.string;

import java.util.Scanner;

public class 대소문자변환 {

    /**
     * [ 설명 ]
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로
     * 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     *
     * [ 입력 ]
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * [ 출력 ]
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     *
     * [ 예시 입력 1 ]
     * StuDY
     *
     * [ 예시 출력 1 ]
     * sTUdy
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        String result = solution(str);
        System.out.println("result = " + result);
    }

    public static String solution(String str) {
        char[] chars = str.toCharArray();

        String result = "";

        for (char c : chars) {
            if (c >= 97 && c <= 122) { // 소문자
//                result += Character.toUpperCase(c);
                // 대문자와 소문자는 아스키 코드 상 32 의 차이가 있다.
                result += (char) (c - 32);
            } else if (c >= 65 && c <= 90) { // 대문자
//                result += Character.toLowerCase(c);
                result += (char) (c + 32);
            } else {
                System.out.println(" 스펠링이 아닙니다. : " + c);
                result += Character.toString(c);
            }
//            if (Character.isLowerCase(c)) {
//                result += Character.toUpperCase(c);
//            } else if (Character.isUpperCase(c)) {
//                result += Character.toLowerCase(c);
//            } else {
//                result += Character.toString(c);
//            }
        }
        return result;
    }
}
