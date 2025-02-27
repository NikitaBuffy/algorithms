package leetcode;

import util.ListNode;

/**
 * LeetCode #203
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        System.out.println(Solution.removeElements(new ListNode(1, new ListNode(2, new ListNode(6,
                new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6));
        System.out.println(Solution.removeElements(null, 1));
        System.out.println(Solution.removeElements(new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))), 7));
    }

    static class Solution {
        public static ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            return dummy.next;
        }
    }
}
