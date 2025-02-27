package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #92
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Solution.reverseBetween(node, 2, 4));
        System.out.println(Solution.reverseBetween(new ListNode(5), 1, 1));
        System.out.println(Solution.reverseBetween(new ListNode(3, new ListNode(5)), 1, 1));
        System.out.println(Solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 3, 3));
    }

    static class Solution {
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            if (head.next == null || left == right) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;

            for (int i = 0; i < left - 1; i++) {
                prev = prev.next;
            }

            ListNode curr = prev.next;
            for (int i = 0; i < right - left; i++) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            return dummy.next;
        }
    }
}
