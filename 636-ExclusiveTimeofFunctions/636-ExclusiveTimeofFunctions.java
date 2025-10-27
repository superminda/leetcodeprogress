// Last updated: 10/26/2025, 8:08:24 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int minPresum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum - minPresum);
            minPresum = Math.min(minPresum, sum);
        }
        return result;
    }
}