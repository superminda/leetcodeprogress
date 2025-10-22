// Last updated: 10/22/2025, 12:40:46 AM
class Solution {
    public long maxKelements(int[] nums, int k) {
        long result = 0l;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2 * k, (a, b) -> (b - a));
        for (int num : nums) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int pollNum = maxHeap.poll();
            result += pollNum;
            maxHeap.offer((pollNum + 2) / 3);
        }
        return result;
    }
}