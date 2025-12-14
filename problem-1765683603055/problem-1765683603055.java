// Last updated: 12/13/2025, 10:40:03 PM
1class Solution {
2    public int absDifference(int[] nums, int k) {
3        Arrays.sort(nums);
4        int sumFirstK = 0;
5        int sumLastK = 0;
6        for (int i = 0; i < k; i++) {
7            sumFirstK += nums[i];
8            sumLastK += nums[nums.length - 1 - i];
9        }
10        return Math.abs(sumFirstK - sumLastK);
11    }
12}