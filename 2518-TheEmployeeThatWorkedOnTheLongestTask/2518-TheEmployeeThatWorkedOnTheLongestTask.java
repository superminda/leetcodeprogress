// Last updated: 10/22/2025, 12:41:01 AM
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int[] counts = new int[n];
        int max = 0;
        int prevTime = 0;
        for (int[] log : logs) {
            int id = log[0];
            int endTime = log[1];
            counts[id] = Math.max(endTime - prevTime, counts[id]);
            max = Math.max(max, counts[id]);
            prevTime = endTime;
        }
        int maxId = -1;
        for (int i = 0; i < n; i++) {
            if (counts[i] == max) {
                maxId = i;
                break;
            }
        }
        return maxId;
    }
}