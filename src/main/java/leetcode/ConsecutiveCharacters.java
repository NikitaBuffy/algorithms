package leetcode;

/**
 * LeetCode #1446
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(Solution.maxPower("abbcccddddeeeeedcba"));
    }

    static class Solution {

        // O(n)
        public static int maxPower(String s) {
            char[] chars = s.toCharArray();
            int max = 1;
            int r = 0;

            for (int i = 0; i < chars.length; i++) {
                while (r + 1 < chars.length && chars[i] == chars[r + 1]) {
                    r++;
                }

                max = Math.max(max, r - i + 1);

                i = r;
            }

            return max;
        }
    }
}
