package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #206
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println(Solution.reverseList(new ListNode(1, new ListNode(2))));
    }

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}
