// Last updated: 10/22/2025, 12:40:32 AM
class Solution {
    public int minOperations(int n) {
        int result = 0;
        while (n > 0) {
            int floorNum = (int)(Math.floor(log2(n)));
            int ceilNum = (int)(Math.ceil(log2(n)));
            int powFloor = (int)Math.pow(2, floorNum);
            int powCeil = (int)Math.pow(2, ceilNum);
            if (Math.abs(powFloor - n) < Math.abs(powCeil - n)) {
                n = n - powFloor;
            } else if (Math.abs(powFloor - n) > Math.abs(powCeil - n)) {
                n = powCeil - n;
            } else {
                n -= powFloor;
            }
            result++;
        }
        return result;
    }
    
    private static double log2(int N) {
        // calculate log2 N indirectly
        // using log() method
        return Math.log(N) / Math.log(2);
    }
}