// Last updated: 4/25/2026, 11:06:06 PM
1class Solution {
2    public List<Integer> findValidElements(int[] nums) {
3        List<Integer> result = new ArrayList<>();
4        if (nums.length == 1) {
5            result.add(nums[0]);
6            return result;
7        }
8        Set<Integer> selected = new HashSet<>();
9        int preMax = nums[0];
10        for (int i = 1; i < nums.length; i++) {
11            if (nums[i] > preMax) {
12                selected.add(i);
13                preMax = nums[i];
14            }
15        }
16        int backMax = nums[nums.length - 1];
17        for (int i = nums.length - 2; i >= 0; i--) {
18            if (nums[i] > backMax) {
19                selected.add(i);
20                backMax = nums[i];
21            }
22        }
23        result.add(nums[0]);
24        for (int i = 1; i < nums.length - 1; i++) {
25            if (selected.contains(i)) {
26                result.add(nums[i]);
27            }
28        }
29        result.add(nums[nums.length - 1]);
30        return result;
31    }
32}