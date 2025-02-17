package leetcode;

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

    static class ListNode {
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        int val;
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
