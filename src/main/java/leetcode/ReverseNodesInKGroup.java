package leetcode;

import util.ListNode;

/**
 * LeetCode #25
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        System.out.println(Solution.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }

    static class Solution {
        public static ListNode reverseKGroup(ListNode head, int k) {
            if (k < 2) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prevGroup = dummy;

            while (true) {
                ListNode kth = getKth(prevGroup, k);
                if (kth == null) {
                    break;
                }
                ListNode nextGroup = kth.next;

                // reversing the group
                ListNode prev = kth.next;
                ListNode curr = prevGroup.next;

                while (curr != nextGroup) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                ListNode tmp = prevGroup.next;
                prevGroup.next = kth;
                prevGroup = tmp;
            }

            return dummy.next;
        }

        public static ListNode getKth(ListNode curr, int k) {
            while (curr != null && k > 0) {
                curr = curr.next;
                k--;
            }
            return curr;
        }
    }
}
