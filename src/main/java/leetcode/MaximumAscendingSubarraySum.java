package leetcode;

/**
 * LeetCode #1800
 */
public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50})); // 65
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50})); // 150
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12})); // 33
    }

    public static int maxAscendingSum(int[] nums) {
        int l = 0, r = 0, maxSum = 0;

        while (l < nums.length) {
            int currSum = 0;
            while (r + 1 < nums.length && nums[r] < nums[r + 1]) {
                currSum += nums[r];
                r++;
            }

            maxSum = Math.max(maxSum, currSum + nums[r]);
            l = r + 1;
            r = r + 1;
        }

        return maxSum;
    }
}
