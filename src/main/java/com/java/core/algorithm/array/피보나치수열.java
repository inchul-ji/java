package com.java.core.algorithm.array;

import java.util.Scanner;

public class 피보나치수열 {
    /**
     * 4. 피보나치 수열
     * [ 설명 ]
     * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
     * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
     *
     *
     * [ 입력 ]
     * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
     *
     * [ 출력 ]
     * 첫 줄에 피보나치 수열을 출력합니다.
     *
     * [ 예시 입력 1 ]
     * 10
     *
     * [ 예시 출력 1 ]
     * 1 1 2 3 5 8 13 21 34 55
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] solution = solution(num);
        System.out.println("============ solution =============");
        for (int i : solution) {
            System.out.print(i + " ");
        }

        int[] icjiSolution = icjiSolution(num);
        System.out.println("");
        System.out.println("============ icji =============");
        for (int i : icjiSolution) {
            System.out.print(i + " ");
        }

        // 배열을 사용하지 않고 출력해 보기 연습.
        solution2(num);


    }

    private static int[] solution(int num) {
        int[] answer = new int[num];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < num; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    private static void solution2(int num) {
        int a = 1;
        int b = 1;
        int c;

        System.out.println("");
        System.out.println(" ========= solution 2 ========= ");
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < num; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    private static int[] icjiSolution(int num) {
        int[] answer = new int[num];

        answer[0] = 1;
        answer[1] = 1;
        for (int i = 0; i < num - 2; i++) {
            int sum = answer[i] + answer[i + 1];
            answer[i + 2] = sum;
        }

        return answer;
    }

}
