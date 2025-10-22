// Last updated: 10/22/2025, 12:40:55 AM
class Solution {
    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}