// Last updated: 11/4/2025, 11:55:04 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            result.add(target.val);
            return result;
        }
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        traverse(root, map, null);
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty() && count < k) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode thisNode = queue.poll();
                for (TreeNode neighbor : map.get(thisNode)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                        if (count == k) {
                            result.add(neighbor.val);
                        }
                    }
                }
            }
        }

        return result;
    }

    private void traverse(TreeNode node, Map<TreeNode, List<TreeNode>> map, TreeNode parent) {
        if (node == null) {
            return;
        }
        List<TreeNode> neighbors = new ArrayList<>();
        if (parent != null) {
            neighbors.add(parent);
        }
        if (node.left != null) {
            neighbors.add(node.left);
            traverse(node.left, map, node);
        }
        if (node.right != null) {
            neighbors.add(node.right);
            traverse(node.right, map, node);
        }
        map.put(node, neighbors);
    }
}