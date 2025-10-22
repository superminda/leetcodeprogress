// Last updated: 10/22/2025, 12:40:22 AM
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return (max + max + k - 1) * k / 2;
    }
}