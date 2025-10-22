// Last updated: 10/22/2025, 12:39:02 AM
class Solution {
    public int longestSubsequence(int[] nums) {
        int nonZeroCount = 0;
        int currentXORResult = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroCount++;
            }
            currentXORResult ^= nums[i];
        }
        if (nonZeroCount == 0) {
            return 0;
        }
        if (currentXORResult == 0) {
            return nums.length - 1;
        }
        return nums.length;
    }
}