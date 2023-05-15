package com.java.core.algorithm.array;

import java.util.Scanner;

public class 격자판최대합 {

    /**
     * 9. 격자판 최대합
     *
     * [ 설명 ]
     * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     *
     * [ Image1.jpg ]
     * ---------------------------
     * | 10 | 13 | 10 | 12 | 15 |
     * | 12 | 32 | 30 | 23 | 11 |
     * | 11 | 25 | 50 | 53 | 15 |
     * | 19 | 27 | 29 | 37 | 27 |
     * | 19 | 13 | 30 | 13 | 19 |
     * ---------------------------
     * 대각선 \ : 한줄
     * 2번째 줄 (13, 32, 25, 27, 13) | : 한줄
     * 가로 2번째 줄 (12, 32, 30, 23, 11) ㅡ : 한줄
     * 대각선 / : 한줄
     *
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
     *
     *
     * [ 입력 ]
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     *
     *
     * [ 출력 ]
     * 최대합을 출력합니다.
     *
     *
     * [ 예시 입력 1 ]
     * 5
     * 10 13 10 12 15
     * 12 39 30 23 11
     * 11 25 50 53 15
     * 19 27 29 37 27
     * 19 13 30 13 19
     *
     * [ 예시 출력 1 ]
     * 155
     *
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[][] array = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int solution = solution(num, array);
        System.out.println("solution = " + solution);

    }

    private static int solution(int num, int[][] array) {
        int answer = Integer.MIN_VALUE;
        int sum1;
        int sum2;

        /**
         * i = 행 번호
         * j = 열 번호
         */
        for (int i = 0; i < num; i++) {
            sum1 = 0; // 행의 합
            sum2 = 0; // 열의 합
            for (int j = 0; j < num; j++) {
                sum1 += array[i][j];
                sum2 += array[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
//            answer = answer > Math.max(sum1, sum2) ? answer : Math.max(sum1, sum2);
        }

        sum1 = 0;
        sum2 = 0;

        for (int i = 0; i < num; i++) {
            sum1 += array[i][i]; // 대각선 계산 ( \ 방향 )
            sum2 += array[i][num -i -1]; // 대각선 계산 ( / 방향 )
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }



}
