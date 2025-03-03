package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #236
 */
public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        System.out.println(Solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
    }

    static class Solution {
        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            if (root.val== p.val || root.val == q.val) {
                return root;
            }

            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);

            if (l != null && r != null) {
                return root;
            } else if (l != null) {
                return l;
            } else {
                return r;
            }
        }
    }
}
