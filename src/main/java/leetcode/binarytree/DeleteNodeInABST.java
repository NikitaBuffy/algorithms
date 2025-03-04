package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #450
 */
public class DeleteNodeInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(7)));
        System.out.println(Solution.deleteNode(root, 3));
    }

    static class Solution {
        public static TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (key < root.val) {
                root.right = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.left = deleteNode(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                TreeNode min = root.right;
                while (min.left != null) {
                    min = min.left;
                }

                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }

            return root;
        }
    }
}