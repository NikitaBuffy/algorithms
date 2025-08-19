package leetcode.slidingwindow;

import java.util.Arrays;

/**
 * LeetCode #567
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(Solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(Solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(Solution.checkInclusion("hello", "ooolleoooleh"));
    }

    static class Solution {

        // O(N + M) -> O(N)
        public static boolean checkInclusion(String s1, String s2) {
            int[] s1Freq = new int[26];
            int[] s2Freq = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                s1Freq[s1.charAt(i) - 'a']++;
            }

            int l = 0;
            for (int r = 0; r < s2.length(); r++) {
                s2Freq[s2.charAt(r) - 'a']++;

                if (r - l + 1 > s1.length()) {
                    s2Freq[s2.charAt(l) - 'a']--;
                    l++;
                }

                if (Arrays.equals(s1Freq, s2Freq)) {
                    return true;
                }

            }

            return false;
        }
    }
}
