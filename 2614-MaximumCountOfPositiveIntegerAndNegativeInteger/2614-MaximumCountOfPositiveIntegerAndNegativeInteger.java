// Last updated: 10/22/2025, 12:40:47 AM
class Solution {
    public int maximumCount(int[] nums) {
        int negCount = 0;
        int posCount = 0;
        int index = 0;
        while (index < nums.length && nums[index] < 0) {
            index++;
            negCount++;
        }
        index = nums.length - 1;
        while (index >= 0 && nums[index] > 0) {
            index--;
            posCount++;
        }
        return Math.max(posCount, negCount);
    }
}