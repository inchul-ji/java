package com.java.core.java_problem.Chapter01.P01_CountDuplicateCharacters.src.modern.challenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {

    private String name;


    public static void main(String[] args) {
        String str = "TEST";
        Map<Character, Integer> characterIntegerMap = countDuplicateCharactersV1(str);

        for (Character character : characterIntegerMap.keySet()) {
            System.out.println("characterIntegerMap = " + characterIntegerMap.get(character));
        }

    }

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
//            result.compute(ch, (k, v) -> {
//                System.out.println("k = " + k);
//                System.out.println("v = " + v);
//                int i1 = (v == null) ? 1 : ++v;
//                System.out.println("i1 = " + i1);
//                return i1;
//            });
        }

        return result;
    }
}
