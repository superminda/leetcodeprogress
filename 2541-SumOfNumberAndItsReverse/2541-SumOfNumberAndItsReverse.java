// Last updated: 10/22/2025, 12:40:57 AM
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 1; i <= num; i++) {
            if (isReverse(i, num - i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isReverse(int num1, int reverseNum) {
        int reversedNum = 0;
        while (num1 > 0) {
            reversedNum *= 10;
            reversedNum += (num1 % 10);
            num1 /= 10;
        }
        return reversedNum == reverseNum;
    }
}