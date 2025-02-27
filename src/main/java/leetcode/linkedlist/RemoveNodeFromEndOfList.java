package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #19
 */
public class RemoveNodeFromEndOfList {
    public static void main(String[] args) {
        System.out.println(Solution.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);

            ListNode left = dummy;
            ListNode right = head;

            for (int i = 0; i < n; i++) {
                right = right.next;
            }

            while (right != null) {
                left = left.next;
                right = right.next;
            }

            ListNode next = left.next;
            left.next = next.next;

            return dummy.next;
        }
    }
}
