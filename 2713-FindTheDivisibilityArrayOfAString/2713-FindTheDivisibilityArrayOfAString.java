// Last updated: 10/22/2025, 12:40:31 AM
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] result = new int[n];
        long currNum = 0;
        for (int i = 0; i < n; i++) {
            char thisChar = word.charAt(i);
            int thisNum = thisChar - '0';
            currNum = currNum * 10 + thisNum;
            if (currNum % m == 0) {
                result[i] = 1;
            }
            currNum %= m;
        }
        return result;
    }
}