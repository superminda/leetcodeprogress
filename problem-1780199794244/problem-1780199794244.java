// Last updated: 5/30/2026, 11:56:34 PM
1class Solution {
2    public int digitFrequencyScore(int n) {
3        int result = 0;
4        while (n > 0) {
5            result += (n % 10);
6            n /= 10;
7        }
8        return result;
9    }
10}