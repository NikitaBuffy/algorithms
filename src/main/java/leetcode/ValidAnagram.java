package leetcode;

import java.util.*;

/**
 * LeetCode #242
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(Solution.isAnagram("anagram", "nagaram"));
        System.out.println(Solution.isAnagram("rat", "car"));
    }

    public static class Solution {
        public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            Arrays.sort(ss);
            Arrays.sort(tt);

            int p1 = 0, p2 = 0;

            while (p1 < ss.length && p2 < tt.length) {
                if (ss[p1] != tt[p2]) {
                    return false;
                }
                p1++;
                p2++;
            }

            return true;
        }
    }
}
