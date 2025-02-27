package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #2095
 */
public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        ListNode example = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        System.out.println(Solution.deleteMiddle(example));
        System.out.println(Solution.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(Solution.deleteMiddle(new ListNode(2, new ListNode(1))));
    }

    static class Solution {
        public static ListNode deleteMiddle(ListNode head) {
            ListNode dummy = new ListNode(0, head);

            ListNode left = dummy;
            ListNode right = head;

            while (right != null && right.next != null) {
                left = left.next;
                right = right.next.next;
            }

            left.next = left.next.next;

            return dummy.next;
        }
    }
}
