package com.java.core.fastcampus;

import java.util.Scanner;

/**
 * [ 문제 ]
 * 알파벳 대소문자로 된 단어가 주어지면,
 * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
 * 단, 대문자와 소문자를 구분하지 않는다.
 *
 * [ 입력 ]
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
 * 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *
 * [ 출력 ]
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
 * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 *
 * [ 예제 입력 1 ]
 * Mississipi
 * [ 예제 출력 1 ]
 * ?
 *
 * [ 예제 입력 2 ]
 * zZa
 * [ 예제 출력 2 ]
 * Z
 *
 * [ 예제 입력 3 ]
 * z
 * [ 예제 출력 3 ]
 * Z
 *
 * [ 예제 입력 4 ]
 * baaa
 * [ 예제 출력 4 ]
 * A
 */
public class 단어공부 {

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            count[ch - 'A']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = getAlphabetCount(str);

        for (int i = 0; i < count.length; i++) {
            System.out.println((char)('A' + i) + " : " + count[i]);
        }

        int maxCount = -1;
        char maxAlphabet = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char)('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);



//        int maxCnt = -1;
//        for (int i = 0; i < 26; i++) {
//            if (count[i] > maxCnt) {
//                maxCnt = count[i];
//            }
//        }
//
//        System.out.println("maxCnt = " + maxCnt);
//        boolean isSameCount = false;
//        for (int i = 0; i < 26; i++) {
//            if (count[i] == maxCnt) {
//                isSameCount = true;
//                System.out.println("isSameCount = " + isSameCount);
//            }
//        }
//
//        System.out.println("icji : " + (isSameCount ? (char) '?' : (char) maxCnt));

    }


}
