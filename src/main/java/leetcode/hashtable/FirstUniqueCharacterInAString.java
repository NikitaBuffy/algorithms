package leetcode.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode #387
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(Solution.firstUniqChar("leetcode"));
        System.out.println(Solution.firstUniqChar("loveleetcode"));
        System.out.println(Solution.firstUniqChar("aabb"));
        System.out.println(Solution.firstUniqChar("dddccdbba"));
    }

    static class Solution {
        public static int firstUniqChar(String s) {
            Map<Character, Integer> counter = new LinkedHashMap<>();

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                counter.put(chars[i], counter.getOrDefault(chars[i], 0) + 1);
            }

            for (int i = 0; i < chars.length; i++) {
                if (counter.get(chars[i]) == 1) return i;
            }

            return -1;
        }
    }
}
