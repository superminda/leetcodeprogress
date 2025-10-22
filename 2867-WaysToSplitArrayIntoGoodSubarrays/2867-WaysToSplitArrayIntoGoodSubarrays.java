// Last updated: 10/22/2025, 12:39:23 AM
class Solution {
    private static int MOD_NUM = (int)(1E9 + 7);
    public int numberOfGoodSubarraySplits(int[] nums) {
        int lastCount = 0;
        int result = 0;
        int prevSum = 1;
        for (int num : nums) {
            if (num == 0) {
                prevSum += lastCount;
                prevSum %= MOD_NUM;
            } else {
                lastCount = prevSum;
            }
        }
        return lastCount;
    }
}