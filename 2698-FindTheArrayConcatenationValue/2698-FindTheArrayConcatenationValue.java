// Last updated: 10/22/2025, 12:40:34 AM
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long result = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            result += Long.valueOf(nums[start] + "" + nums[end]);
            start++;
            end--;
        }
        if (start == end) {
            result += nums[start];
        }
        return result;
    }
}