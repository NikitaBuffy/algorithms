package leetcode;

/**
 * LeetCode #26
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(2 == Solution.removeDuplicates(new int[]{ 1, 1, 2 }));
        System.out.println(5 == Solution.removeDuplicates(new int[]{ 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }

    static class Solution {
        public static int removeDuplicates(int[] nums) {
            int l = 0, r = 1, idx = 1;

            while (r < nums.length) {
                if (nums[l] != nums[r]) {
                    nums[idx] = nums[r];
                    l = r;
                    idx++;
                } else {
                    r++;
                }
            }

            return idx;
        }
    }
}
