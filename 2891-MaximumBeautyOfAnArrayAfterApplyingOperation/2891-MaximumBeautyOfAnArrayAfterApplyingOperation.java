// Last updated: 10/22/2025, 12:39:18 AM
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        int backIndex = 0;
        int index = 0;
        while (index < nums.length) {
            while (backIndex < nums.length) {
                if (nums[backIndex] - 2 * k <= nums[index]) {
                    backIndex++;
                } else {
                    break;
                }
            }
            result = Math.max(result, backIndex - index);
            int startIndex = index;
            while (index < nums.length) {
                if (nums[index] == nums[startIndex]) {
                    index++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}