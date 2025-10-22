// Last updated: 10/22/2025, 12:40:34 AM
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(nums);
        Arrays.sort(divisors);
        int result = divisors[0];
        int count = 0;
        for (int i = 0; i < divisors.length; i++) {
            int divisor = divisors[i];
            int thisCount = 0;
            for (int j = nums.length - 1; j >= 0; j--) {
                int num = nums[j];
                if (num < divisor) {
                    break;
                }
                if (num % divisor == 0) {
                    thisCount++;
                }
            }
            if (thisCount > count) {
                result = divisor;
                count = thisCount;
            }
        }
        return result;
    }
}