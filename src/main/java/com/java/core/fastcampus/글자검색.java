package com.java.core.fastcampus;

import java.util.Scanner;

/**
 * [ 문제 ]
 * 세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다.
 * 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다.
 * 그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다.
 * 예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면,
 * 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다.
 * 그러나 동시에 셀 수는 없다.
 *
 * 세준이는 문서와 검색하려는 단어가 주어졌을 때,
 * 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.
 *
 * [ 입력 ]
 * 첫째 줄에 문서가 주어진다. 문서의 길이는 최대 2500이다.
 * 둘째 줄에 검색하고 싶은 단어가 주어진다.
 * 이 길이는 최대 50이다.
 * 문서와 단어는 알파벳 소문자와 공백으로 이루어져 있다.
 *
 * [ 출력 ]
 * 첫째 줄에 중복되지 않게 최대 몇 번 등장하는지 출력한다.
 *
 * [ 예제 입력 1 ]
 * ababababa
 * aba
 * [ 예제 출력 1 ]
 * 2
 *
 * [ 예제 입력 2 ]
 * a a a a a
 * a a
 * [ 예제 출력 2 ]
 * 2
 *
 * [ 예제 입력 3 ]
 * ababababa
 * ababa
 * [ 예제 출력 3 ]
 * 1
 *
 * [ 예제 입력 4 ]
 * aaaaaaa
 * aa
 * [예제 출력 4 ]
 * 3
 */
public class 글자검색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String doc = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int startIndex = 0;

        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) {
                break;
            }
            count++;
            startIndex = findIndex + word.length();
        }

        // 문제를 그대로 읽고 정석으로 푼 방법.
        System.out.println("count = " + count);


        // 그냥 답만 맞추는 꼼수.
        String replaced = doc.replace(word, "");
        System.out.println("replaced = " + replaced);
        int length = doc.length() - replaced.length();
        int cnt = length / word.length();

        System.out.println("cnt = " + cnt);

        // 지인철의 다른 꼼수
        String[] split = doc.split(word);
//        for (String s : split) {
//            System.out.println("s = " + s);
//        }
        System.out.println("split = " + (split.length - 1));

    }
}
