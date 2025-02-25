package leetcode;

/**
 * LeetCode #125
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(Solution.isPalindrome("race a car"));
        System.out.println(Solution.isPalindrome(" "));
    }

    static class Solution {
        public static boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }

            char[] chars = s.toLowerCase().toCharArray();
            int l = 0, r = chars.length - 1;

            while (l < r) {
                while (l < r && !Character.isLetterOrDigit(chars[l])) {
                    l++;
                }
                while (l < r && !Character.isLetterOrDigit(chars[r])) {
                    r--;
                }
                if (chars[l] != chars[r]) {
                    return false;
                }
                l++;
                r--;
            }

            return true;
        }
    }
}
