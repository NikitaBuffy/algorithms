package leetcode;

/**
 * LeetCode #268
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(Solution.missingNumber(new int[]{3,0,1}));
    }

    static class Solution {
        public static int missingNumber(int[] nums) {
            int n = nums.length;

            int expected = (n * (n + 1)) / 2;
            int actual = 0;

            for (int i = 0; i < n; i++) {
                actual += nums[i];
            }

            return expected - actual;
        }
    }
}
