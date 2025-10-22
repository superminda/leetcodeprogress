// Last updated: 10/22/2025, 12:40:28 AM
class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                result = Math.max(result, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                result = Math.max(result, nums[i][n - i - 1]);
            }
        }
        
        return result;
    }
    
    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}