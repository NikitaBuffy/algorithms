package leetcode;

/**
 * LeetCode #392
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(Solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(Solution.isSubsequence("b", "c"));
    }

    static class Solution {
        public static boolean isSubsequence(String s, String t) {
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();

            int l = 0;
            int r = 0;

            while (l < s1.length && r < s2.length) {
                char letter = s1[l];

                while (r < s2.length && letter != s2[r]) {
                    r++;
                }

                if (r < s2.length) {
                    l++;
                    r++;
                }
            }

            return l >= s1.length;
        }
    }
}
