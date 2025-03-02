package leetcode.binarytree;

import util.TreeNode;

/**
 * LeetCode #938
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3),
                        new TreeNode(7)),
                new TreeNode(15,
                        null,
                        new TreeNode(18)));
        System.out.println(Solution.rangeSumBST(root, 7 , 15));
    }

    static class Solution {
        static int sum = 0;

        public static int rangeSumBST(TreeNode root, int low, int high) {
            dfs(root, low, high);
            return sum;
        }

        public static void dfs(TreeNode node, int low, int high) {
            if (node != null) {
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }
                dfs(node.left, low, high);
                dfs(node.right, low, high);
            }
        }
    }
}
