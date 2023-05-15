package com.java.core.algorithm.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OneMore {

    private static final int ALPHABET_TOTAL_LENGTH = 26;

//    public static int[] getAlphabetCount(String str) {
//        int[] countArr = new int[ALPHABET_TOTAL_LENGTH];
//        for (int i = 0; i < str.length(); i++) {
//            countArr[str.charAt(i) - 'A']++;
//        }
//        return countArr;
//    }

    public static int solution(String doc, String word) {
        int answer = 0;

        String replaced = doc.replace(word, "");
        int length = doc.length() - replaced.length();
        int count = length / word.length();
        System.out.println("count = " + count);



        int startIndex = 0;
        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) {
                break;
            }
            startIndex = findIndex + word.length();
            answer++;
        }

//        for (int i = 0; i < doc.length(); i++) {
//            boolean isMatch = true;
//            for (int j = 0; j < word.length(); j++) {
//                if (i + j >= doc.length() ||
//                        doc.charAt(i+j) != word.charAt(j)) {
//                    isMatch = false;
//                    break;
//                }
//            }
//            if (isMatch) {
//                answer++;
//                // -1 은 반복문이 끝날때마다 i++ 이 동작하기 때문에 해당 값이 들어가는것을 고려하여 해준다.
//                i += word.length() - 1;
//            }
//        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(solution(input1, input2));
    }

}
