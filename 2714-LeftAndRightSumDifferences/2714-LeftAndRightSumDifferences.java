// Last updated: 10/22/2025, 12:40:32 AM
class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        for (int index = 0; index < n; index++) {
            result[index] = Math.abs(leftSum[index] - rightSum[index]);
        }
        return result;
    }
}