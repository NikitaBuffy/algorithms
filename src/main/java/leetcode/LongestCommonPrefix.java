package leetcode;

import java.util.List;

/**
 * LeetCode #14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefixOptimized(List.of("flower","flow","flight")));
        System.out.println(longestCommonPrefixOptimized(List.of("dog","racecar","car")));
    }

    // O(N * L^2)
    public static String longestCommonPrefix(String[] strs) {
        String firstWord = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int counter = firstWord.length() - 1;
            while (!strs[i].startsWith(firstWord)) {
                firstWord = firstWord.substring(0, counter);
                counter--;
            }
        }

        return firstWord;
    }

    // O(N * M)
    public static String longestCommonPrefixOptimized(List<String> strs) {
        // Определяем минимальную длину строки среди всех
        int minLen = strs.get(0).length();
        for (String el : strs) {
            minLen = Math.min(minLen, el.length());
        }

        // Проверяем совпадение символов на каждой позиции до minLen
        for (int i = 0; i < minLen; i++) {
            char ch = strs.get(0).charAt(i);
            for (String el : strs) {
                if (el.charAt(i) != ch) {
                    return el.substring(0, i);
                }
            }
        }

        // Все символы совпадают на отрезке длины minLen
        return strs.get(0).substring(0, minLen);
    }
}

