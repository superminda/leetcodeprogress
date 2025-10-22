// Last updated: 10/22/2025, 12:40:45 AM
class Solution {
    public int alternateDigitSum(int n) {
        int result = 0;
        int numOfDigits = 0;
        boolean isPositive = true;
        while (n > 0) {
            result += (isPositive ? 1 : -1) * (n % 10);
            n /= 10;
            isPositive = !isPositive;
            numOfDigits++;
        }
        if (numOfDigits % 2 == 0) {
            return -result;
        } else {
            return result;
        }
    }
}