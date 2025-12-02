// Last updated: 12/1/2025, 11:34:32 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode dummyNode = new ListNode();
14        ListNode currentNode = dummyNode;
15        int carry = 0;
16        while (l1 != null || l2 != null) {
17            int sum = carry;
18            if (l1 != null) {
19                sum += l1.val;
20                l1 = l1.next;
21            }
22            if (l2 != null) {
23                sum += l2.val;
24                l2 = l2.next;
25            }
26            if (sum >= 10) {
27                carry = 1;
28            } else {
29                carry = 0;
30            }
31            ListNode newNode = new ListNode(sum % 10);
32            currentNode.next = newNode;
33            currentNode = newNode;
34        }
35        if (carry != 0) {
36            ListNode newNode = new ListNode(carry);
37            currentNode.next = newNode;
38        }
39        return dummyNode.next;
40    }
41}