package com.java.core.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 보이는학생 {

    /**
     * 2. 보이는 학생
     * [ 설명 ]
     * 선생님이 N명의 학생을 일렬로 세웠습니다.
     * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
     * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
     * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     *
     * [ 입력 ]
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다.
     * 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     *
     *
     * [ 출력 ]
     * 선생님이 볼 수 있는 최대 학생 수를 출력한다.
     *
     *
     * [ 예시 입력 1 ]
     * 8
     * 130 135 148 140 145 150 150 153
     *
     * [ 예시 출력 1 ]
     * 5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int[] students = new int[count];
        for (int i = 0; i < count; i++) {
            students[i] = in.nextInt();
        }

        int icjiSolution = icjiSolution(students);
        System.out.println("icjiSolution = " + icjiSolution);

        int solution = solution(count, students);
        System.out.println("solution = " + solution);
    }

    private static int solution(int count, int[] students) {
        int answer = 1;
        int max = students[0];
        for (int i = 0; i < count; i++) {
            if (students[i] > max) {
                answer++;
                max = students[i];
            }
        }
        return answer;
    }

    private static int icjiSolution(int[] students) {
        List<Integer> answer = new ArrayList<>();
        answer.add(students[0]);
        for (int i = 1; i < students.length; i++) {
            if (answer.get(answer.size() - 1) < students[i]) {
                answer.add(students[i]);
            }
        }
        return answer.size();
    }


}
