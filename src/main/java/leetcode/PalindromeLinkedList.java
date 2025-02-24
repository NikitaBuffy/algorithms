package leetcode;

/**
 * LeetCode #234
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(Solution.isPalindrome(new ListNode(1, new ListNode(2))));
    }

    static class Solution {
        public static boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            // Finding the middle of linked list
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            ListNode curr = slow;

            // Reversing second part of linked list
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Comparing reversed part and head
            while (prev != null) {
                if (prev.val != head.val) {
                    return false;
                }
                prev = prev.next;
                head = head.next;
            }

            return true;
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
