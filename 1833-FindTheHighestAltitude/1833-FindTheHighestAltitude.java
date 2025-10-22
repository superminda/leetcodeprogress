// Last updated: 10/22/2025, 12:41:12 AM
class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int sum = 0;
        for (int num : gain) {
            sum += num;
            result = Math.max(result, sum);
        }
        return result;
    }
}