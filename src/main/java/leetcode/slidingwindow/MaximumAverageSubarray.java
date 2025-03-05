package leetcode.slidingwindow;

/**
 * LeetCode #643
 */
public class MaximumAverageSubarray {
    public static void main(String[] args) {
        System.out.println(Solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(Solution.findMaxAverage(new int[]{5}, 1));
    }

    static class Solution {
        public static double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            double avg = 0;

            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }

            avg = (double) sum / k;

            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k];
                avg = Math.max(avg, (double) sum / k);
            }

            return avg;
        }
    }
}
