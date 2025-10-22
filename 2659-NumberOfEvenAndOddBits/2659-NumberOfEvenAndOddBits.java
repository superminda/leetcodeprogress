// Last updated: 10/22/2025, 12:40:38 AM
class Solution {
    public int[] evenOddBit(int n) {
        int[] result = new int[2];
        int index = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                result[index % 2]++;
            }
            index++;
            n /= 2;
        }
        return result;
    }
}