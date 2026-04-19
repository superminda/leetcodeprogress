// Last updated: 4/19/2026, 12:14:45 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        if (n == 1) {
5            if (k >= 0) {
6                return 0;
7            }
8            return -1;
9        }
10        int[] preMax = new int[n];
11        preMax[0] = nums[0];
12        for (int i = 1; i < nums.length; i++) {
13            preMax[i] = Math.max(preMax[i - 1], nums[i]);
14        }
15        int[] preMin = new int[n];
16        preMin[n - 1] = nums[n - 1];
17        for (int i = n - 2; i >= 0; i--) {
18            preMin[i] = Math.min(preMin[i + 1], nums[i]);
19        }
20        int smallestScore = k + 1;
21        int smallestIndex = -1;
22        for (int i = 0; i < n; i++) {
23            int thisScore = preMax[i] - preMin[i];
24            if (thisScore < smallestScore) {
25                smallestIndex = i;
26                smallestScore = thisScore;
27                return smallestIndex;
28            }
29        }
30        return -1;
31    }
32}