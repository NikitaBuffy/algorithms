package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode #214
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(Solution.shortestPalindrome("aacecaaa"));
        System.out.println(Solution.shortestPalindrome("abcd"));
    }

    static class Solution {
        public static String shortestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            String temp = s + "#" + new StringBuilder(s).reverse();

            int[] pi = computePrefixFunction(temp);

            int palPrefixLength = pi[temp.length() - 1];

            String suffix = s.substring(palPrefixLength);
            return new StringBuilder(suffix).reverse() + s;
        }

        private static int[] computePrefixFunction(String str) {
            int n = str.length();
            int[] pi = new int[n];
            int j = 0;

            for (int i = 1; i < n; i++) {
                while (j > 0 && str.charAt(i) != str.charAt(j)) {
                    j = pi[j - 1];
                }
                if (str.charAt(i) == str.charAt(j)) {
                    j++;
                }
                pi[i] = j;
            }
            return pi;
        }
    }

    /**
     * O(N^2) решение
     */
    static class WeakSolution {
        public static String shortestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            char[] arr = s.toCharArray();

            LinkedList<Character> tail = new LinkedList<>();
            LinkedList<Character> head = new LinkedList<>();

            for (char c : arr) {
                tail.add(c);
            }

            if (checkPalindrome(tail)) {
                return s;
            }

            LinkedList<Character> result = new LinkedList<>();

            int idx = tail.size() - 1;
            while(!checkPalindrome(result)) {
                Character last = tail.get(idx);
                head.addLast(last);
                result.clear();
                result.addAll(head);
                result.addAll(tail);
                idx--;
            }

            StringBuilder builder = new StringBuilder();
            result.forEach(builder::append);
            return builder.toString();
        }

        private static boolean checkPalindrome(List<Character> list) {
            if (list.isEmpty() || list.size() == 1) {
                return false;
            }
            int l = 0, r = list.size() - 1;
            while (l < r) {
                if (list.get(l) != list.get(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}