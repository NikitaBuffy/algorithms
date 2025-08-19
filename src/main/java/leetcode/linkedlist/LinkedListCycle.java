package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #141
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        System.out.println(Solution.hasCycle(new ListNode(3, new ListNode(2))));
    }

    static class Solution {
        public static boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                } else {
                    slow = slow.next;
                    fast = fast.next.next;
                }
            }

            return true;
        }
    }
}
