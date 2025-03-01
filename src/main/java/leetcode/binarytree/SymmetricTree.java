package leetcode.binarytree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode #111
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)));
        System.out.println(Solution.isSymmetric(root));
    }

    static class Solution {
        public static boolean isSymmetric(TreeNode root) {
            if (root == null) return false;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);

            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if (left == null && right == null) continue;
                if (left == null || right == null || left.val != right.val) return false;

                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
        }
    }
}
