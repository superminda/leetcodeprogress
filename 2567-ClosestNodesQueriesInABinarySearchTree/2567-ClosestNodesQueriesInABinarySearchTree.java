// Last updated: 10/22/2025, 12:40:54 AM
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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            List<Integer> subResult = new ArrayList<>();
            int min = -1;
            int max = -1;
            TreeNode currNode = root;
            while (currNode != null) {
                if (currNode.val < query) {
                    min = currNode.val;
                    currNode = currNode.right;
                } else if (currNode.val > query) {
                    max = currNode.val;
                    currNode = currNode.left;
                } else {
                    min = max = currNode.val;
                    break;
                }
            }
            subResult.add(min);
            subResult.add(max);
            result.add(subResult);
        }
        return result;
    }
}