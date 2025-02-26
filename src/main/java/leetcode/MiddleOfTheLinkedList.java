package leetcode;

import util.ListNode;

/**
 * LeetCode #876
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        System.out.println(Solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println(Solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
    }

    static class Solution {
        public static ListNode middleNode(ListNode head) {
            ListNode dummy = new ListNode(0, head);

            ListNode left = dummy;
            ListNode right = head;

            while (right != null && right.next != null) {
                left = left.next;
                right = right.next.next;
            }

            return left.next;
        }
    }
}
