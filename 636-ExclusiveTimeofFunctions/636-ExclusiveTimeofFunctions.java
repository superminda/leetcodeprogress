// Last updated: 10/26/2025, 6:20:17 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        ListNode left = head;
        ListNode prev = null;
        while (right != null) {
            right = right.next;
            prev = left;
            left = left.next;
        }
        if (left == head) {
            return head.next;
        } else {
            prev.next = left.next;
            return head;
        }
    }
}