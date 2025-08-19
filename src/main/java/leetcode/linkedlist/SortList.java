package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #148
 */
public class SortList {
    public static void main(String[] args) {
        System.out.println(Solution.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))))));
    }

    static class Solution {
        public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode left = head;
            ListNode right = getMiddle(head);
            ListNode tmp = right.next;
            right.next = null;
            right = tmp;

            left = sortList(left);
            right = sortList(right);

            return merge(left, right);
        }

        private static ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (left != null && right != null){
                if (left.val < right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }

            if (left != null) {
                tail.next = left;
            }
            if (right != null) {
                tail.next = right;
            }

            return dummy.next;
        }

        private static ListNode getMiddle(ListNode head) {
            ListNode slow = head, fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}
