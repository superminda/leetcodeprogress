// Last updated: 10/22/2025, 12:39:17 AM
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() == 2) {
            return true;
        }
        int n = nums.size();
        int[] prefixSum = new int[n + 1];
        for (int index = 0; index < nums.size(); index++) {
            prefixSum[index + 1] = prefixSum[index] + nums.get(index);
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (prefixSum[i + 1] - prefixSum[i - 1] >= m) {
                dp[i - 1][i] = true;
                // System.out.println(i);
                // System.out.println(i + 1);
            }
        }
        for (int len = 3; len <= nums.size(); len++) {
            for (int start = 0; start + len <= nums.size(); start++) {
                for (int splitIndex = start; splitIndex < start + len - 1; splitIndex++) {
                    if (dp[start][splitIndex] && dp[splitIndex + 1][start + len - 1]) {
                        dp[start][start + len - 1] = true;
                        // System.out.println(start);
                        // System.out.println(start + len - 1);
                        break;
                    }
                }
            }
        }
        // System.out.println("end");
        return dp[0][n - 1];
    }
}