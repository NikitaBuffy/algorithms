package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #700
 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        System.out.println(Solution.searchBST(new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7)), 2));
    }

    static class Solution {
        public static TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }

            if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }
}
