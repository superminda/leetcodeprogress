// Last updated: 12/1/2025, 10:52:56 PM
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
12    public ListNode mergeKLists(ListNode[] lists) {
13        int k = lists.length;
14        if (k == 0) {
15            return null;
16        }
17        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k, (a, b) -> (a.val - b.val));
18        for (ListNode list : lists) {
19            if (list == null) {
20                continue;
21            }
22            heap.offer(list);
23        }
24        ListNode dummyNode = new ListNode();
25        ListNode currentNode = dummyNode;
26        while (!heap.isEmpty()) {
27            ListNode pollNode = heap.poll();
28            currentNode.next = pollNode;
29            currentNode = pollNode;
30            if (pollNode.next != null) {
31                heap.offer(pollNode.next);
32            }
33        }
34        return dummyNode.next;
35    }
36}