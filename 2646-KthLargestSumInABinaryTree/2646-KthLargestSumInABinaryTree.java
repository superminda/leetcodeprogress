// Last updated: 10/22/2025, 12:40:42 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>(k, (a, b) -> (a.compareTo(b)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0l;
            for (int index = 0; index < size; index++) {
                TreeNode thisNode = queue.poll();
                sum += thisNode.val;
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
            heap.offer(sum);
            if (heap.size() == k + 1) {
                heap.poll();
            }
        }
        if (heap.size() != k) {
            return -1;
        }
        return heap.poll();
    }
}