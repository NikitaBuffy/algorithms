package leetcode.linkedlist;

import util.ListNode;

/**
 * LeetCode #21
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println(Solution.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))));
    }

    static class Solution {

        // O(N + M)
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }

            if (list1 != null) {
                prev.next = list1;
            }

            if (list2 != null) {
                prev.next = list2;
            }

            return dummy.next;
        }
    }
}
