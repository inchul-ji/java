package com.java.core.fastcampus;

import java.util.Scanner;

/**
 * [ 애너그램 만들기 ]
 *
 * 두 영어 단어가 철자의 순서를 뒤바꾸어 같아질 수 있을 때, 그러한 두 단어를 서로 애너그램 관계에 있다고 한다.
 * 예를 들면 occurs 라는 영어 단어와 succor 는 서로 애너그램 관계에 있는데, occurs의 각 문자들의 순서를 잘 바꾸면 succor이 되기 때문이다.
 *
 * 한 편, dared와 bread는 서로 애너그램 관계에 있지 않다. 하지만 dared에서 맨 앞의 d를 제거하고,
 * bread에서 제일 앞의 b를 제거하면, ared와 read라는 서로 애너그램 관계에 있는 단어가 남게 된다.
 *
 * 두 개의 영어 단어가 주어졌을 때, 두 단어가 서로 애너그램 관계에 있도록 만들기 위해서 제거해야 하는
 * 최소 개수의 문자 수를 구하는 프로그램을 작성하시오. 문자를 제거할 때에는 아무 위치에 있는 문자든지 제거할 수 있다.
 *
 * [ 입력 ]
 * 첫째 줄과 둘째 줄에 영어 단어가 소문자로 주어진다.
 * 각각의 길이는 1,000자를 넘지 않으며, 적어도 한 글자로 이루어진 단어가 주어진다.
 *
 * [ 출력 ]
 * 첫째 줄에 답을 출력한다.
 *
 * [ 예제 입력 1 ]
 * aabbcc
 * xxyybb
 *
 * [ 예제 출력 1 ]
 * 8
 *
 */
public class 애너그램만들기 {

    /**
     * 공통 부문 함수와
     * @param str
     * @return
     */
    public static int[] getAlphabetCount(String str) {
        // TODO: 소문자 개수만큼 공간 확보
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int answer = 0;
        for (int i = 0; i < countA.length; i++) {
            /**
             * countA[i] - countB[i] 계산 값이 음수가 나올 수 있는데
             * Math.abs() 를 통해 음수가 나오더라도 절대값이 나오도록 하여
             * if() 문을 통해 구분하는 로직을 제거 할 수 있다.
             */
            answer += Math.abs(countA[i] - countB[i]);
//            if (countA[i] > countB[i]) {
//                answer += countA[i] - countB[i];
//            } else if (countA[i] < countB[i]) {
//                answer += countB[i] - countA[i];
//            }
        }

        System.out.println(answer);
    }



}
