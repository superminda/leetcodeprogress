// Last updated: 12/4/2025, 12:25:27 AM
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4        List<Integer> subResult = new ArrayList<>();
5        List<Integer> emptyResult = new ArrayList<>();
6        result.add(emptyResult);
7        for (int i = 0; i < nums.length; i++) {
8            dfs(nums, i, result, subResult);
9        }
10        return result;
11    }
12
13    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> subResult) {
14        if (index == nums.length) {
15            return;
16        }
17        subResult.add(nums[index]);
18        List<Integer> newSubResult = new ArrayList<>();
19        newSubResult.addAll(subResult);
20        result.add(newSubResult);
21        for (int i = index + 1; i < nums.length; i++) {
22            dfs(nums, i, result, subResult);
23        }
24        subResult.remove(subResult.size() - 1);
25    }
26}