package leetcode;

/**
 * LeetCode #485
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(Solution.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(Solution.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    static class Solution {
        public static int findMaxConsecutiveOnes(int[] nums) {
            int maxNum = 0, count = 0;

            for (int num : nums) {
                if (num == 1) {
                    count++;
                    maxNum = Math.max(maxNum, count);
                } else {
                    count = 0;
                }
            }

            return maxNum;
        }
    }
}
