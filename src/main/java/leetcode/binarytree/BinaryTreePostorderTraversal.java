package leetcode.binarytree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #145
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        System.out.println(Solution.postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7))),
                new TreeNode(3,
                        null,
                        new TreeNode(8,
                                new TreeNode(9),
                                null)));
        System.out.println(Solution.postorderTraversal(root));
    }

    static class Solution {
        public static List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            dfs(root, result);

            return result;
        }

        private static void dfs(TreeNode node, ArrayList<Integer> result) {
            if (node != null) {
                dfs(node.left, result);
                dfs(node.right, result);
                result.add(node.val);
            }
        }
    }
}
