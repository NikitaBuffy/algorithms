package leetcode.binarytree;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;

/**
 * LeetCode #109
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(Solution.sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))))));
    }

    static class Solution {
        public static TreeNode sortedListToBST(ListNode head) {
            ArrayList<Integer> nums = new ArrayList<>();

            ListNode curr = head;

            while (curr != null) {
                nums.add(curr.val);
                curr = curr.next;
            }

            return buildTree(nums, 0, nums.size() - 1);
        }

        private static TreeNode buildTree(ArrayList<Integer> nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) / 2;

            TreeNode node = new TreeNode(nums.get(mid));

            node.left = buildTree(nums, left, mid - 1);
            node.right = buildTree(nums, mid + 1, right);

            return node;
        }
    }
}
