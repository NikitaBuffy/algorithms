package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #230
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6));

        System.out.println(Solution.kthSmallest(root, 3));
    }

    static class Solution {
        static int index = 0;

        public static int kthSmallest(TreeNode root, int k) {
            return inorder(root, k).val;
        }

        private static TreeNode inorder(TreeNode node, int k) {
            if (node == null) {
                return null;
            }

            TreeNode result = inorder(node.left, k);
            if (result != null) {
                return result;
            }

            index += 1;
            if (k == index) {
                return node;
            }

            return inorder(node.right, k);
        }
    }
}
