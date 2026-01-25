// Last updated: 1/24/2026, 10:03:37 PM
1class Solution {
2    public int minimumPrefixLength(int[] nums) {
3        int n = nums.length;
4        int min = nums[n - 1];
5        for (int index = n - 2; index >= 0; index--) {
6            if (nums[index] < min) {
7                min = nums[index];
8            } else {
9                return index + 1;
10            }
11        }
12        return 0;
13    }
14}