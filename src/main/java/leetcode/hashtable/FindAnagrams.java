package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #438
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(Solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(Solution.findAnagrams("abab", "ab"));
    }

    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> pMap = new HashMap<>();
            Map<Character, Integer> sMap = new HashMap<>();

            if (s.length() < p.length()) return result;

            char[] pChar = p.toCharArray();

            for (int i = 0; i < pChar.length; i++) {
                pMap.put(pChar[i], pMap.getOrDefault(pChar[i], 0) + 1);
            }

            int l = 0, r = 0;

            while (r < s.length()) {
                char c = s.charAt(r);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (r - l == p.length() - 1) {
                    if (sMap.equals(pMap)) {
                        result.add(l);
                    }

                    char lChar = s.charAt(l);
                    sMap.put(lChar, sMap.get(lChar) - 1);
                    if (sMap.get(lChar) == 0) {
                        sMap.remove(lChar);
                    }

                    l++;
                }

                r++;
            }

            return result;
        }
    }
}
