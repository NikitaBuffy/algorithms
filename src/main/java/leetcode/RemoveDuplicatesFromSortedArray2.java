package leetcode;

/**
 * LeetCode #80
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        System.out.println(5 == Solution.removeDuplicates(new int[]{ 1, 1, 1, 2, 2, 3 }));
        System.out.println(7 == Solution.removeDuplicates(new int[]{ 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
    }

    static class Solution {
        public static int removeDuplicates(int[] nums) {
            int idx = 1, count = 1;

            for (int r = 1; r < nums.length; r++) {
                if (nums[r] == nums[r - 1]) {
                    if (count < 2) {
                        nums[idx++] = nums[r];
                    }
                    count++;
                } else {
                    nums[idx++] = nums[r];
                    count = 1;
                }
            }

            return idx;
        }
    }
}
