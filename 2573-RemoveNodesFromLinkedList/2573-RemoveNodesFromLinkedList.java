// Last updated: 10/22/2025, 12:40:51 AM
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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int max = stack.peek().val;
        ListNode result = stack.pop();
        while (!stack.isEmpty()) {
            ListNode thisNode = stack.pop();
            if (thisNode.val < max) {
                continue;
            }
            max = thisNode.val;
            thisNode.next = result;
            result = thisNode;
        }
        return result;
    }
}