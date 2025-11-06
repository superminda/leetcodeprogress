// Last updated: 11/6/2025, 12:45:34 AM
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (head.next == head) {
            newNode.next = head;
            head.next = newNode;
            return head;
        }
        Node maxNode = head;
        Node currNode = head.next;
        Node prevNode = head;
        do {
            if (prevNode.val > currNode.val) {
                maxNode = prevNode;
            }

            if (prevNode.val <= insertVal && currNode.val >= insertVal) {
                newNode.next = currNode;
                prevNode.next = newNode;
                return head;
            }
            prevNode = currNode;
            currNode = currNode.next;
        } while (prevNode != head);
        Node minNode = maxNode.next;
        maxNode.next = newNode;
        newNode.next = minNode;
        return head;
    }
}