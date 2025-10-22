// Last updated: 10/22/2025, 12:40:45 AM
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> (b[k] - a[k]));
        return score;
    }
}