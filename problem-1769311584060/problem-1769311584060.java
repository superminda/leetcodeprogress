// Last updated: 1/24/2026, 10:26:24 PM
1class Solution {
2    public int[] rotateElements(int[] nums, int k) {
3        int n = nums.length;
4        int[] result = new int[n];
5        List<Integer> nonNegList = new ArrayList<>();
6        for (int num : nums) {
7            if (num >= 0) {
8                nonNegList.add(num);
9            }
10        }
11        if (nonNegList.isEmpty()) {
12            return nums;
13        }
14        k = k % nonNegList.size();
15        reverse(nonNegList, 0, k - 1);
16        reverse(nonNegList, k, nonNegList.size() - 1);
17        reverse(nonNegList, 0, nonNegList.size() - 1);
18        int fillIndex = 0;
19        for (int index = 0; index < nums.length; index++) {
20            if (nums[index] < 0) {
21                result[index] = nums[index];
22            } else {
23                result[index] = nonNegList.get(fillIndex);
24                fillIndex++;
25            }
26        }
27        return result;
28    }
29
30    private void reverse(List<Integer> list, int start, int end) {
31        while (start < end) {
32            int temp = list.get(start);
33            list.set(start, list.get(end));
34            list.set(end, temp);
35            start++;
36            end--;
37        }
38    }
39}