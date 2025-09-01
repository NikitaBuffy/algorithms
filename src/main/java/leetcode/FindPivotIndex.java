package leetcode;

/**
 * LeetCode #724
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6})); // 3
        System.out.println(pivotIndex(new int[]{1,2,3})); // -1
        System.out.println(pivotIndex(new int[]{2,1,-1})); // 0
    }

    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
