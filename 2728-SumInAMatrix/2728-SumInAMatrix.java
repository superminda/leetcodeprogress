// Last updated: 10/22/2025, 12:40:26 AM
class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] num: nums) {
            Arrays.sort(num);
        }
        int score = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i][j]);
            }
            score += max;
        }
        return score;
    }
}