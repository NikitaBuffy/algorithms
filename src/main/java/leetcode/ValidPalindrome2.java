package leetcode;

/**
 * LeetCode #680
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("racecarx"));
        System.out.println(Solution.isPalindrome("aba"));
        System.out.println(Solution.isPalindrome("abca"));
        System.out.println(Solution.isPalindrome("racecar"));
        System.out.println(Solution.isPalindrome("deeee"));
        System.out.println(Solution.isPalindrome("abc"));
    }

    static class Solution {
        public static boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }

            char[] chars = s.toLowerCase().toCharArray();
            int l = 0, r = chars.length - 1;

            return isPalindrome(chars, l, r, 1);
        }

        private static boolean isPalindrome(char[] chars, int l, int r, int k) {
            while (l < r) {
                if (chars[l] != chars[r]) {
                    if (k == 0) return false;
                    return isPalindrome(chars, l + 1, r, k - 1) || isPalindrome(chars, l, r - 1, k - 1);
                }
                l++;
                r--;
            }

            return true;
        }
    }
}
