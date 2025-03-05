package leetcode.slidingwindow;

/**
 * LeetCode #674
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(Solution.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(Solution.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    static class Solution {
        public static int findLengthOfLCIS(int[] nums) {
            int l = 0, r = 0, max = 0;

            while (l < nums.length) {
                while (r + 1 < nums.length && nums[r] < nums[r + 1]) {
                    r++;
                }

                max = Math.max(max, r - l + 1);
                l = r + 1;
                r = r + 1;
            }

            return max;
        }
    }
}
