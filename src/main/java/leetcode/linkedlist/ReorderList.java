package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #143
 */
public class ReorderList {
    public static void main(String[] args) {
        System.out.println(Solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(Solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }

    static class Solution {
        public static ListNode reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;

            // Split linked list into two parts by slow and fast pointers (finding the middle)
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = slow.next;
            ListNode prev = null;
            slow.next = null;

            // Reversing the second part
            while (second != null) {
                ListNode next = second.next;
                second.next = prev;
                prev = second;
                second = next;
            }

            ListNode first = head;
            second = prev;

            // Merging two parts
            while (second != null) {
                ListNode tmp1 = first.next;
                ListNode tmp2 = second.next;
                first.next = second;
                second.next = tmp1;
                second = tmp2;
                first = tmp1;
            }

            return head;
        }
    }
}
