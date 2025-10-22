// Last updated: 10/22/2025, 12:40:35 AM
class Solution {
    public long pickGifts(int[] gifts, int k) {
        long result = 0l;
        PriorityQueue<Integer> heap = new PriorityQueue<>(gifts.length, (a, b) -> (b - a));
        for (int gift : gifts) {
            result += gift;
            heap.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int pollNum = heap.poll();
            int newNum = (int) Math.floor(Math.sqrt(pollNum));
            heap.offer(newNum);
            result -= pollNum;
            result += newNum;
        }
        return result;
    }
}