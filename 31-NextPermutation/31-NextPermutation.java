// Last updated: 12/4/2025, 1:49:03 AM
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        int closestSum = (int)1E7;
4        Arrays.sort(nums);
5        for (int i = 0; i < nums.length - 2; i++) {
6            for (int j = i + 1; j < nums.length - 1; j++) {
7                int targetNum = target - nums[i] - nums[j];
8                int index = findBiggestNumberIndexSmallerOrEqual(nums, targetNum, j + 1);
9                if (index == -1) {
10                    int sumDiff = Math.abs(targetNum - nums[j + 1]);
11                    if (sumDiff < Math.abs(closestSum - target)) {
12                        closestSum = nums[i] + nums[j] + nums[j + 1];
13                    }
14                } else if (nums[index] == targetNum) {
15                    return target;
16                } else if (nums[index] > targetNum) {
17                    int sumDiff = Math.abs(targetNum - nums[index]);
18                    if (sumDiff < Math.abs(closestSum - target)) {
19                        closestSum = nums[i] + nums[j] + nums[index];
20                    }
21                } else {
22                    int sumDiff = Math.abs(targetNum - nums[index]);
23                    if (sumDiff < Math.abs(closestSum - target)) {
24                        closestSum = nums[i] + nums[j] + nums[index];
25                    }
26                    if (index + 1 <= nums.length - 1) {
27                        sumDiff = Math.abs(targetNum - nums[index + 1]);
28                        if (sumDiff < Math.abs(closestSum - target)) {
29                            closestSum = nums[i] + nums[j] + nums[index + 1];
30                        }
31                    }
32                }
33            }
34        }
35        return closestSum;
36    }
37
38    private int findBiggestNumberIndexSmallerOrEqual(int[] nums, int targetNum, int startIndex) {
39        int left = startIndex;
40        int right = nums.length - 1;
41        while (left + 1 < right) {
42            int mid = left + (right - left) / 2;
43            int midNum = nums[mid];
44            if (midNum <= targetNum) {
45                left = mid;
46            } else {
47                right = mid - 1;
48            }
49        }
50        if (nums[right] <= targetNum) {
51            return right;
52        } else if (nums[left] <= targetNum) {
53            return left;
54        } else {
55            return -1;
56        }
57    }
58}