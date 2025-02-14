package leetcode;

/**
 * LeetCode #557
 */
public class ReverseWordsInAString3 {
    public static void main(String[] args) {
        String case1 = Solution.reverseWords("Let's take LeetCode contest");
        System.out.println(case1.equals("s'teL ekat edoCteeL tsetnoc"));

        String case2 = Solution.reverseWords("Mr Ding");
        System.out.println(case2.equals("rM gniD"));
    }

    static class Solution {
        public static String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;

            int l = 0;
            while (l < n) {
                while (l < n && chars[l] == ' ') {
                    l++;
                }
                if (l >= n) break;

                int r = l;
                while (r < n && chars[r] != ' ') {
                    r++;
                }

                reverse(chars, l, r - 1);
                l = r;
            }

            return new String(chars);
        }

        private static void reverse(char[] arr, int l, int r) {
            while (l < r) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
}
