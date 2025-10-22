// Last updated: 10/22/2025, 12:40:56 AM
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return (int)Math.floor((double)sum / count);
    }
}