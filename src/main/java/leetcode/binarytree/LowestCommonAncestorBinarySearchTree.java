package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #235
 */
public class LowestCommonAncestorBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));
        System.out.println(Solution.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5)));
    }

    static class Solution {
        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode curr = root;

            while (curr != null) {
                if (p.val > curr.val && q.val > curr.val) {
                    curr = curr.right;
                } else if (p.val < curr.val && q.val < curr.val) {
                    curr = curr.left;
                } else {
                    return curr;
                }
            }

            return null;
        }
    }
}
