package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #108
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(Solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    static class Solution {
        public static TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private static TreeNode build(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) / 2;

            TreeNode node = new TreeNode(nums[mid]);

            node.left = build(nums, left, mid - 1);
            node.right = build(nums, mid + 1, right);

            return node;
        }
    }
}
