// Last updated: 11/29/2025, 10:32:29 PM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int result = Integer.MAX_VALUE;
4        Map<Long, Integer> map = new HashMap<>();
5        for (int index = 0; index < nums.length; index++) {
6            int thisNum = nums[index];
7            if (map.containsKey((long)(thisNum))) {
8                result = Math.min(result, index - map.get((long)(thisNum)));
9            }
10            long reverseNumber = getReverseNumber(nums[index]);
11            map.put(reverseNumber, index);
12        }
13        if (result == Integer.MAX_VALUE) {
14            return -1;
15        }
16        return result;
17    }
18
19    private long getReverseNumber(int num) {
20        long result = 0l;
21        while (num > 0) {
22            int rem = num % 10;
23            result = result * 10 + rem;
24            num /= 10;
25        }
26        return result;
27    }
28}