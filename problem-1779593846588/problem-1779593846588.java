// Last updated: 5/23/2026, 11:37:26 PM
1class Solution {
2    public int[] limitOccurrences(int[] nums, int k) {
3        List<Integer> newList = new ArrayList<>();
4        newList.add(nums[0]);
5        int count = 1;
6        for (int i = 1; i < nums.length; i++) {
7            if (nums[i] == nums[i - 1]) {
8                if (count == k) {
9                    continue;
10                }
11                count++;
12                newList.add(nums[i]);
13            } else {
14                count = 1;
15                newList.add(nums[i]);
16            }
17        }
18        int[] result = new int[newList.size()];
19        for (int i = 0; i< newList.size(); i++) {
20            result[i] = newList.get(i);
21        }
22        return result;
23    }
24}