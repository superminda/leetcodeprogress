// Last updated: 11/29/2025, 10:07:51 PM
1class Solution {
2    public int countElements(int[] nums, int k) {
3        int n = nums.length;
4        if (k == 0) {
5            return n;
6        }
7        int minEvictedNumber = Integer.MAX_VALUE;
8        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(n, (a, b) -> (b - a));
9        for (int num : nums) {
10            heap.offer(num);
11            if (heap.size() == n - k + 1) {
12                int evictedNumber = heap.poll();
13                minEvictedNumber = Math.min(minEvictedNumber, evictedNumber);
14            }
15        }
16        while (!heap.isEmpty() && heap.peek() == minEvictedNumber) {
17            heap.poll();
18        }
19        return heap.size();
20    }
21}