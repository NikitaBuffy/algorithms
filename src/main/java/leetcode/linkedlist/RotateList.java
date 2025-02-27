package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #61
 */
public class RotateList {
    public static void main(String[] args) {
        System.out.println(Solution.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
        System.out.println(Solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }

    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (k < 1) {
                return head;
            }

            int length = 1;
            ListNode tail = head;

            while (tail.next != null) {
                tail = tail.next;
                length++;
            }

            k = k % length;
            if (k == 0) {
                return head;
            }

            ListNode curr = head;

            for (int i = 0; i < length - k - 1; i++) {
                curr = curr.next;
            }

            ListNode start = curr.next;
            curr.next = null;
            tail.next = head;

            return start;
        }
    }
}
