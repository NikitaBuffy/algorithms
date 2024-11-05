package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #3
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        int case1 = Solution.lengthOfLongestSubstring("abcabcbb");
        int case2 = Solution.lengthOfLongestSubstring("bbbbb");
        System.out.println(case1);
        System.out.println(case2);
    }

    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            Set<Character> charSet = new HashSet<>();
            int right = 0;
            int left = 0;
            int maxLen = 0;

            while (right < s.length()) {
                if (!charSet.contains(s.charAt(right))) {
                    charSet.add(s.charAt(right));

                    if (maxLen < charSet.size()) {
                        maxLen = charSet.size();
                    }

                    right++;
                } else {
                    charSet.remove(s.charAt(left));
                    left++;
                }
            }

            return maxLen;
        }
    }
}