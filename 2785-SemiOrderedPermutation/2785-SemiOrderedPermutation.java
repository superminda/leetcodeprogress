// Last updated: 10/22/2025, 12:40:18 AM
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int oneIndex = 0;
        int nIndex = 0;
        for (int index = 0; index < n; index++) {
            if (nums[index] == 1) {
                oneIndex = index;
            } else if (nums[index] == n) {
                nIndex = index;
            }
        }
        if (oneIndex < nIndex) {
            return oneIndex + (n - 1 - nIndex);
        } else {
            return oneIndex + (n - 1 - nIndex) - 1;
        }
    }
}