// Last updated: 10/22/2025, 12:40:30 AM
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int endIndex = nums.length - 1;
        int startIndex = nums.length / 2 - 1;
        while (startIndex >= 0) {
            if ((long)nums[startIndex] * 2l <= (long)nums[endIndex]) {
                count += 2;
                endIndex--;
            }
            startIndex--;
        }
        return count;
    }
}