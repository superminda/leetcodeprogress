// Last updated: 10/22/2025, 12:39:05 AM
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int result = 0;
        for (int num = 1; num <= 100; num++) {
            if (count[num] != 0 && count[num] % k == 0) {
                result += count[num] * num;
            }
        }
        return result;
    }
}