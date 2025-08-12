package leetcode;

/**
 * LeetCode #1493
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(Solution.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(Solution.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(Solution.longestSubarray(new int[]{1,1,1}));
        System.out.println(Solution.longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }

    public static class Solution {
        public static int longestSubarray(int[] nums) {
            int n = nums.length;
            int zeros = (nums[0] == 0) ? 1 : 0;
            int r = 0;
            int res = 0;

            for (int l = 0; l < n; l++) {
                while (r + 1 < n && zeros + ((nums[r + 1] == 0) ? 1 : 0) < 2) {
                    r++;
                    if (nums[r] == 0) zeros++;
                }
                res = Math.max(res, r - l);
                if (nums[l] == 0) zeros--;
            }

            return res;
        }
    }
}
