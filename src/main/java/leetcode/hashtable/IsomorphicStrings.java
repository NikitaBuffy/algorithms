package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #205
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(Solution.isIsomorphic("egg", "add"));
        System.out.println(Solution.isIsomorphic("foo", "bat"));
        System.out.println(Solution.isIsomorphic("paper", "title"));
        System.out.println(Solution.isIsomorphic("badc", "baba"));
    }

    static class Solution {
        public static boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Character> storage1 = new HashMap<>();
            Map<Character, Character> storage2 = new HashMap<>();

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            for (int i = 0; i < ss.length; i++) {
                if (!storage1.containsKey(ss[i])) {
                    storage1.put(ss[i], tt[i]);
                }
                if (!storage2.containsKey(tt[i])) {
                    storage2.put(tt[i], ss[i]);
                }

                if (storage1.get(ss[i]) != tt[i] || storage2.get(tt[i]) != ss[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
