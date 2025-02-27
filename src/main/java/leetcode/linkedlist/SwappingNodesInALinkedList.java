package leetcode.linkedlist;

import util.ListNode;

import java.util.ArrayList;

/**
 * LeetCode #1721
 */
public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Solution.swapNodes(node, 2));
    }

    static class Solution {
        public static ListNode swapNodes(ListNode head, int k) {
            ArrayList<ListNode> nodes = new ArrayList<>();

            ListNode dummy = new ListNode(0, head);
            ListNode temp = dummy.next;

            while (temp != null) {
                nodes.add(temp);
                temp = temp.next;
            }

            ListNode first = nodes.get(k - 1);
            ListNode last = nodes.get(nodes.size() - k);

            int t = first.val;
            first.val = last.val;
            last.val = t;

            return dummy.next;
        }
    }
}
