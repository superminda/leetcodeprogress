// Last updated: 10/22/2025, 12:40:41 AM
class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        long[] dp = new long[target + 1];
        dp[0] = 1l;
        for (int[] type : types) {
            int count = type[0];
            int mark = type[1];
            count = Math.min(target / mark, count);
            long[] newDp = new long[target + 1];
            for (int tempIndex = 1; tempIndex <= count; tempIndex++) {
                for (int index = target; index >= tempIndex * mark; index--) {
                    newDp[index] = newDp[index - mark] + dp[index-mark];
                }
            }
            for (int loopIndex = 0; loopIndex <= target; loopIndex++) {
                dp[loopIndex] += newDp[loopIndex];
                dp[loopIndex] %= (long)(1E9 + 7);
            }
        }
        
        return (int)dp[target];
    }
}