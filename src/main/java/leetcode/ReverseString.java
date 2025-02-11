package leetcode;

/**
 * LeetCode #344
 */
public class ReverseString {
    public static void main(String[] args) {
        Solution.reverseString(new char[]{ 'h', 'e', 'l', 'l', 'o'});
        Solution.reverseString2(new char[]{ 'h', 'e', 'l', 'l', 'o'});
        Solution.reverseString(new char[]{ 'H', 'a', 'n', 'n', 'a', 'h'});
        Solution.reverseString2(new char[]{ 'H', 'a', 'n', 'n', 'a', 'h'});
    }

    static class Solution {
        public static void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                s[left] = (char) (s[left] ^ s[right]);
                s[right] = (char) (s[left] ^ s[right]);
                s[left] = (char) (s[left] ^ s[right]);

                left++;
                right--;
            }

            System.out.println(s);
        }

        public static void reverseString2(char[] s) {
            int l = 0;
            int r = s.length - 1;

            while (l < r) {
                char temp = s[l];
                s[l] = s[r];
                s[r] = temp;
                l++;
                r--;
            }

            System.out.println(s);
        }
    }
}
