package leetcode.slidingwindow;

import java.util.ArrayList;

/**
 * LeetCode #443
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(Solution.compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    static class Solution {
        // Time: O(N), space: O(1)
        public static int compress(char[] chars) {
            int index = 0, count = 0;

            for (int i = 0; i < chars.length; i++) {
                count++;

                if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                    chars[index++] = chars[i];
                    if (count != 1) {
                        for (char c : String.valueOf(count).toCharArray()) {
                            chars[index++] = c;
                        }
                    }
                    count = 0;
                }
            }

            return index;
        }

        // Time: O(N), space: O(N)
        public static int compress2(char[] chars) {
            int l = 0, r = 0;
            ArrayList<Character> result = new ArrayList<>();

            while (l < chars.length) {
                while (r + 1 < chars.length && chars[r] == chars[r + 1]) {
                    r++;
                }

                int windowSize = r - l + 1;
                result.add(chars[l]);

                if (windowSize > 1) {
                    for (char c : String.valueOf(windowSize).toCharArray()) {
                        result.add(c);
                    }
                }

                l = r + 1;
                r = r + 1;
            }

            return result.size();
        }
    }
}
