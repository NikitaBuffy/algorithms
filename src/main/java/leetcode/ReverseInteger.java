package leetcode;

/**
 * LeetCode #7
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(321 == Solution.reverse(123));
        System.out.println(-321 == Solution.reverse(-123));
        System.out.println(21 == Solution.reverse(120));
        System.out.println(0 == Solution.reverse(-2147483648));
    }

    static class Solution {
        public static int reverse(int x) {
            long res = 0;
            boolean negative = false;

            if (x < 0) {
                x = x * -1;
                negative = true;
            }

            while (x > 0) {
                res = 10 * res + (x % 10);
                x = x / 10;
            }

            if (res > Integer.MAX_VALUE) return 0;

            if (negative) {
                return (int) res * -1;
            }

            return (int) res;
        }

        public static int reverse2(int x) {
            boolean negative = false;
            long temp = x;

            if (temp < 0) {
                temp = temp * -1;
                negative = true;
            }

            char[] arr = String.valueOf(temp).toCharArray();

            if (arr.length == 1) {
                return x;
            }

            int l = 0, r = arr.length - 1;

            while (l < r) {
                if (arr[r] == 0) {
                    r--;
                }
                char t = arr[r];
                arr[r] = arr[l];
                arr[l] = t;
                l++;
                r--;
            }

            long result = Long.parseLong(new String(arr));

            if (result > Integer.MAX_VALUE) return 0;

            if (negative) {
                return (int) result * -1;
            }

            return (int) result;
        }
    }
}
