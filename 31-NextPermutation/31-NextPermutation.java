// Last updated: 12/1/2025, 12:45:43 AM
1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        int result = 0;
4        int n = nums.length;
5        int left = 0;
6        int usedCount = 0;
7        for (int index = 0; index < n; index++) {
8            if (nums[index] == 0) {
9                if (k != 0) {
10                    while (usedCount == k) {
11                        if (nums[left] == 0) {
12                            usedCount--;
13                        }
14                        left++;
15                    }
16                    usedCount++;
17                    result = Math.max(result, index - left + 1);
18                } else {
19                    left = index + 1;
20                }
21            } else {
22                result = Math.max(result, index - left + 1);
23            }
24        }
25        return result;
26    }
27}