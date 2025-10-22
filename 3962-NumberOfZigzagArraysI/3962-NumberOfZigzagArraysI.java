// Last updated: 10/22/2025, 12:39:10 AM
// class Solution {
//     public int zigZagArrays(int n, int l, int r) {
//         int mod = 1000000007;
//         r = r - l;
//         l = 0;
//         int[][][] dp = new int[n][r + 1][2]; // 0 up, 1 down
//         int[] upPreSum = new int[r + 1];
//         int[] downPreSum = new int[r + 1];
//         for (int i = 0; i <= r; i++) {
//             dp[0][i][0] = 1;
//             dp[0][i][1] = 1;
//             upPreSum[i] = i + 1;
//             downPreSum[i] = r - i + 1;
//         }
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j <= r; j++) {
//                 if (j != 0) {
//                     dp[i][j][1] += upPreSum[j - 1];
//                     dp[i][j][1] = dp[i][j][1] % mod;
//                 }
//                 if (j != r) {
//                     dp[i][j][0] += downPreSum[j + 1];
//                     dp[i][j][0] = dp[i][j][0] % mod;
//                 }
//             }
//             upPreSum[0] = dp[i][0][0];
//             for (int index = 1; index <= r; index++) {
//                 upPreSum[index] = dp[i][index][0] + upPreSum[index - 1];
//                 upPreSum[index] %= mod;
//             }
//             downPreSum[r] = dp[i][r][1];
//             for (int index = r - 1; index >= 0; index--) {
//                 downPreSum[index] = dp[i][index][1] + downPreSum[index + 1];
//                 downPreSum[index] %= mod;
//             }
//         }
//         int result = 0;
//         for (int i = 0; i <= r; i++) {
//             result = result + dp[n - 1][i][0];
//             result = result % mod;
//             result = result + dp[n - 1][i][1];
//             result = result % mod;
//         }
//         return result;
//     }
// }

class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1000000007;
        r = r - l;
        l = 0;
        int[][] dp = new int[r + 1][2]; // 0 up, 1 down
        int[] upPreSum = new int[r + 1];
        int[] downPreSum = new int[r + 1];
        for (int i = 0; i <= r; i++) {
            upPreSum[i] = i + 1;
            downPreSum[i] = r - i + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= r; j++) {
                if (j != 0) {
                    dp[j][1] = upPreSum[j - 1];
                }
                if (j != r) {
                    dp[j][0] = downPreSum[j + 1];
                }
            }
            upPreSum[0] = dp[0][0];
            for (int index = 1; index <= r; index++) {
                upPreSum[index] = dp[index][0] + upPreSum[index - 1];
                upPreSum[index] %= mod;
            }
            downPreSum[r] = dp[r][1];
            for (int index = r - 1; index >= 0; index--) {
                downPreSum[index] = dp[index][1] + downPreSum[index + 1];
                downPreSum[index] %= mod;
            }
        }
        int result = 0;
        for (int i = 0; i <= r; i++) {
            result = result + dp[i][0];
            result = result % mod;
            result = result + dp[i][1];
            result = result % mod;
        }
        return result;
    }
}