package leetcode;

/**
 * LeetCode #541
 */
public class ReverseString2 {
    public static void main(String[] args) {
        var case1 = Solution.reverseStr("abcdefg", 2);
        var case2 = Solution.reverseStr("abcd", 2);
        System.out.println(case1);
        System.out.println(case2);
    }

    static class Solution {
        public static String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int n = arr.length;

            for (int i = 0; i < n; i += 2 * k) {
                int l = i;
                int r = Math.min(l + k - 1, n - 1);
                while (l < r) {
                    char temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++;
                    r--;
                }
            }

            return new String(arr);
        }
    }
}
