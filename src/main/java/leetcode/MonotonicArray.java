package leetcode;

/**
 * LeetCode #896
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isInc = true;
        boolean isDec = true;

        for (int i = 1; i < nums.length; i++) {
            isInc = isInc && nums[i - 1] <= nums[i];
            isDec = isDec && nums[i - 1] >= nums[i];
        }

        return isInc || isDec;
    }
}
