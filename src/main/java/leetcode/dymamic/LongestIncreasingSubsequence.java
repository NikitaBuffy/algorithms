package leetcode.dymamic;

import java.util.Arrays;

/**
 * Leetcode #300
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(4 == lengthOfLIS(new int[]{4,10,5,12,3,24,7,8}));
        System.out.println(4 == lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(4 == lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(1 == lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        return max;
    }
}
