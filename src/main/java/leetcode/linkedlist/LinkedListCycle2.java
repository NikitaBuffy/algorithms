package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #142
 */
public class LinkedListCycle2 {
    public static void main(String[] args) {
        System.out.println(Solution.detectCycle(new ListNode(3, new ListNode(2))));
    }

    static class Solution {
        public static ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }

            if (fast == null || fast.next == null) {
                return null;
            }

            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }
}
