package leetcode.linkedlist;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #3217
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 2, 3 };
        ListNode example = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(Solution.modifiedList(nums, example));
    }

    static class Solution {
        public static ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num);
            }

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null) {
                if (set.contains(curr.val)) {
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            return dummy.next;
        }
    }
}
