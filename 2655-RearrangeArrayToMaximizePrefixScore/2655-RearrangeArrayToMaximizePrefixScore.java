// Last updated: 10/22/2025, 12:40:40 AM
class Solution {
    public int maxScore(int[] nums) {
        int score = 0;
        long sum = 0l;
        Arrays.sort(nums);
        int index = nums.length - 1;
        while (index >= 0 && nums[index]> 0) {
            sum += nums[index--];
            score++;
        }
        
        while (index >= 0) {
            if (sum + (long)nums[index] > 0l) {
                sum += nums[index--];
                score++;
                continue;
            }
            break;
        }
        return score;
    }
}