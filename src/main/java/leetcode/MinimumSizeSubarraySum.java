package leetcode;

/**
 * LeetCode #209
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(Solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(Solution.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(Solution.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    static class Solution {
        public static int minSubArrayLen(int target, int[] nums) {
            int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                while (sum >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left++];
                }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}
