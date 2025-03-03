package leetcode;

/**
 * LeetCode #704
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(Solution.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(Solution.search(new int[]{-1,0,3,5,9,12}, 2));
    }

    static class Solution {
        public static int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return -1;
        }
    }
}
