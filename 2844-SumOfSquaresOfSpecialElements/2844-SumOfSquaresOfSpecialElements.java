// Last updated: 10/22/2025, 12:39:28 AM
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            if (n % (index + 1) == 0) {
                result += nums[index] * nums[index];
            }
        }
        return result;
    }
}