// Last updated: 10/22/2025, 12:39:08 AM
class Solution {
    public int earliestTime(int[][] tasks) {
        int result = tasks[0][0] + tasks[0][1];
        for (int i = 1; i < tasks.length; i++) {
            result = Math.min(result, tasks[i][0] + tasks[i][1]);
        }
        return result;
    }
}