package com.java.core.algorithm.array;

import java.util.Scanner;

public class 가위바위보 {

    /**
     * 3. 가위 바위 보
     * [ 설명 ]
     * A, B 두 사람이 가위바위보 게임을 합니다.
     * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
     * 비길 경우에는 D를 출력합니다.
     * 가위, 바위, 보의 정보는 아래와 같이 정하겠습니다.
     * 1:가위,
     * 2:바위,
     * 3:보
     * <p>
     * 예를 들어 N=5이면
     * <p>
     * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
     * | 회수     | 1 | 2 | 3 | 4 | 5 |
     * | A의 정보  | 2 | 3 | 3 | 1 | 3 |
     * | B의 정보  | 1 | 1 | 2 | 2 | 3 |
     * | 승자     | A | B | A | B | D |
     * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
     * <p>
     * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를
     * 누가 이겼는지 출력하는 프로그램을 작성하세요.
     * <p>
     * <p>
     * [ 입력 ]
     * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * <p>
     * [ 출력 ]
     * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     * <p>
     * [ 예시 입력 1 ]
     * 5
     * 2 3 3 1 3
     * 1 1 2 2 3
     * <p>
     * [ 예시 출력 1 ]
     * A
     * B
     * A
     * B
     * D
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[count];
        for (int i = 0; i < count; i++) {
            b[i] = in.nextInt();
        }

        char[] icjiSolution = icjiSolution(count, a, b);
        for (char c : icjiSolution) {
            System.out.println(c);
        }

        String solution = solution(count, a, b);
        for (char c : solution.toCharArray()) {
            System.out.println("c = " + c);
        }

    }

    //    1 < 2
//    2 < 3
//    3 < 1
    private static char[] icjiSolution(int count, int[] A, int[] B) {
        char[] answer = new char[count];
        for (int i = 0; i < count; i++) {
            if (A[i] == 1) {
                if (B[i] == 1) {
                    answer[i] = 'D';
                } else if (B[i] == 2) {
                    answer[i] = 'B';
                } else {
                    answer[i] = 'A';
                }
            } else if (A[i] == 2) {
                if (A[i] == 1) {
                    if (B[i] == 1) {
                        answer[i] = 'A';
                    } else if (B[i] == 2) {
                        answer[i] = 'D';
                    } else {
                        answer[i] = 'B';
                    }
                }
            } else {
                if (A[i] == 1) {
                    if (B[i] == 1) {
                        answer[i] = 'B';
                    } else if (B[i] == 2) {
                        answer[i] = 'A';
                    } else {
                        answer[i] = 'D';
                    }
                }
            }
        }
        return answer;
    }

    private static String solution(int count, int[] a, int[] b) {
        String answer = "";

        for (int i = 0; i < count; i++) {
            if (a[i] == b[i]) {
                answer += "D";
            } else if (a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if (a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if (a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }
        return answer;
    }

}
