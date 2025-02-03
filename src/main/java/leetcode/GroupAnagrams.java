package leetcode;

import java.util.*;

/**
 * LeetCode #49
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] case1 = {"eat","tea","tan","ate","nat","bat"};
        String[] case2 = {""};
        String[] case3 = {"a"};

        System.out.println(Solution.groupAnagrams(case1));
        System.out.println(Solution.groupAnagrams(case2));
        System.out.println(Solution.groupAnagrams(case3));
    }

    public static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }

            return new ArrayList<>(map.values());
        }
    }
}
