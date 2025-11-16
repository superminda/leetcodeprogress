// Last updated: 11/15/2025, 10:59:49 PM
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - 1] + nums[n - 2] - nums[0];
    }
}