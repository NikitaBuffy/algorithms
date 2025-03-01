package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #98
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(Solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }

    static class Solution {
        public static boolean isValidBST(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private static boolean validate(TreeNode node, long min, long max) {
            if (node == null) return true;
            if (node.val <= min || node.val >= max) return false;
            return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        }
    }
}
