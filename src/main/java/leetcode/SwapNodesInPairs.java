package leetcode;

import util.ListNode;

/**
 * LeetCode #24
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println(Solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(Solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }

    static class Solution {
        public static ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = head;

            while (curr != null && curr.next != null) {
                ListNode nextPair = curr.next.next;
                ListNode next = curr.next;

                next.next = curr;
                curr.next = nextPair;
                prev.next = next;

                prev = curr;
                curr = nextPair;
            }

            return dummy.next;
        }
    }
}
