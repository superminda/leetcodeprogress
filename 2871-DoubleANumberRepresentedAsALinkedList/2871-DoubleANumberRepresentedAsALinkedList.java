// Last updated: 10/22/2025, 12:39:23 AM
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
    public ListNode doubleIt(ListNode head) {
        Pair<ListNode, Integer> doubleResult = helper(head);
        if (doubleResult.getValue() == 0) {
            return doubleResult.getKey();
        }
        ListNode newHead = new ListNode(doubleResult.getValue());
        newHead.next = doubleResult.getKey();
        return newHead;
    }
    
    private Pair<ListNode, Integer> helper(ListNode node) {
        if (node == null) {
            return null;
        }
        int thisNum = node.val * 2;
        Pair<ListNode, Integer> nextResult = helper(node.next);
        if (nextResult != null) {
            thisNum += nextResult.getValue();
        }
        ListNode newNode = new ListNode(thisNum % 10);
        if (nextResult != null) {
            newNode.next = nextResult.getKey();
        }
        return new Pair<>(newNode, thisNum / 10);
    }
}