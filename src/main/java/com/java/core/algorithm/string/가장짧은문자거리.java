package com.java.core.algorithm.string;

import java.util.Scanner;

public class 가장짧은문자거리 {

    /**
     * 10. 가장 짧은 문자거리
     *
     * [ 설명 ]
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가
     * 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     *
     * [ 입력 ]
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다.
     * 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     *
     * [ 출력 ]
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     *
     * [ 예시 입력 1 ]
     * teachermode e
     *
     * [ 예시 출력 1 ]
     * 1 0 1 2 1 0 1 2 2 1 0
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        char target = in.next().charAt(0);

        int[] solution = solution(source, target);
        for (int i : solution) {
            System.out.print(i + " ");
        }
//        System.out.println("solution = " + solution.toString());

    }


    private static int[] solution(String source, char target) {
        int[] answer = new int[source.length()];

        int pointer = 1000;

        // 오른쪽으로 비교
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target) {
                pointer = 0;
                answer[i] = pointer;
            } else {
                pointer++;
                answer[i] = pointer;
            }
        }

        pointer = 1000;
        // 왼쪽을 비교
        for (int i = source.length() - 1; i >= 0; i--) {
            if (source.charAt(i) == target) {
                pointer = 0;
                // 어차피 위에서 채워져있기 때문에 의미 없다.
//                answer[i] = pointer;
            } else {
                pointer++;
                answer[i] = Math.min(answer[i], pointer); // 둘 중 작은 값을 넣겠다.
            }
        }

        return answer;
    }

}
