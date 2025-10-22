// Last updated: 10/22/2025, 12:39:29 AM
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < 3; i++) {
            int num = nums[i];
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for (int i = 0; i < 3; i++) {
            int num = nums[i];
            if (num < max && num > min) {
                return num;
            }
        }
        return -1;
    }
}