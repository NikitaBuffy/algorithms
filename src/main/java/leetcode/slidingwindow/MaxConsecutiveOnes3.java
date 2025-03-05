package leetcode.slidingwindow;

/**
 * LeetCode #1004
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        System.out.println(Solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(Solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    static class Solution {
        public static int longestOnes(int[] nums, int k) {
            int left = 0, zeros = 0, maxLen = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    zeros++;
                }

                while (zeros > k) {
                    if (nums[left] == 0) zeros--;
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }
}
