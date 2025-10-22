// Last updated: 10/22/2025, 12:40:19 AM
class Solution {
    public int minIncrements(int n, int[] cost) {
        int result = 0;
        int[] costSum = new int[n + 1];
        int maxSum = 0;
        costSum[1] = cost[0];
        for (int i = 2; i <= n; i++) {
            costSum[i] = cost[i - 1] + costSum[i / 2];
            if (i > n / 2) {
                maxSum = Math.max(maxSum, costSum[i]);
            }
        }
        int[] array = new int[n + 1];
        for (int i = n / 2 + 1; i <= n; i++) {
            array[i] = costSum[i];
        }
        int end = n / 2;
        while (end > 0) {
            int start = end / 2 + 1;
            for (int index = start; index <= end; index++) {
                int left = array[2 * index];
                int right = array[2 * index + 1];
                array[index] = Math.max(left, right);
                result += (Math.max(left, right) - Math.min(left, right));
            }
            end /= 2;
        }
        return result;
    }
}