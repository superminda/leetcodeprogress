// Last updated: 10/26/2025, 6:08:22 PM
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

class CountResult {
    public final int sum;
    public final int count;
    public CountResult(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
class Solution {
    private int result;
    public int averageOfSubtree(TreeNode root) {
        this.result = 0;
        count(root);
        return this.result;
    }

    private CountResult count(TreeNode root) {
        if (root == null) {
            return null;
        }
        CountResult leftResult = count(root.left);
        CountResult rightResult = count(root.right);
        int sum = root.val;
        int count = 1;
        if (leftResult != null) {
            sum += leftResult.sum;
            count += leftResult.count;
        }
        if (rightResult != null) {
            sum += rightResult.sum;
            count += rightResult.count;
        }
        int avg = sum / count;
        if (avg == root.val) {
            this.result++;
        }
        return new CountResult(sum, count);
    }
}