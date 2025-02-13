package leetcode;

/**
 * LeetCode #151
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String case1 = Solution.reverseWords("  hello world  ");
        String case11 = Solution.reverseWords2("  hello world  ");
        System.out.println(case1.equals("world hello"));
        System.out.println(case11.equals("world hello"));

        String case2 = Solution.reverseWords("the sky is blue");
        String case22 = Solution.reverseWords("the sky is blue");
        System.out.println(case2.equals("blue is sky the"));
        System.out.println(case22.equals("blue is sky the"));

        String case3 = Solution.reverseWords("a good   example");
        String case33 = Solution.reverseWords("a good   example");
        System.out.println(case3.equals("example good a"));
        System.out.println(case33.equals("example good a"));
    }

    static class Solution {
        /*
         * Mostly O(1) space complexity with in-place solution (instead of new String creation at the end)
         */
        public static String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            reverse(chars, 0, n - 1);

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

            return removeWhitespaces(chars);
        }

        /*
         * Basic O(n) space complexity with regular expression
         */
        public static String reverseWords2(String s) {
            String[] arr = s.trim().split("\\s+");
            StringBuilder result = new StringBuilder();
            int n = arr.length;

            for (int i = n - 1; i > 0; i--) {
                result.append(arr[i]).append(" ");
            }

            result.append(arr[0]);
            return result.toString();
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

        private static String removeWhitespaces(char[] arr) {
            int n = arr.length;
            int l = 0, r = 0;

            while (l < n && arr[l] == ' ') l++;

            while (l < n) {
                while (l < n && arr[l] != ' ') {
                    arr[r++] = arr[l++];
                }

                while (l < n && arr[l] == ' ') l++;

                if (l < n) {
                    arr[r++] = ' ';
                }
            }

            return new String(arr, 0, r);
        }
    }
}
