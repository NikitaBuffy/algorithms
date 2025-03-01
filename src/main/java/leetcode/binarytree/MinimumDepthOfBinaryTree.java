package leetcode.binarytree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode #111
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(Solution.minDepth(root));
    }

    static class Solution {
        public static int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) return depth;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                depth++;
            }

            return depth;
        }
    }
}
