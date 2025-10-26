// Last updated: 10/26/2025, 5:13:47 PM
class Solution {
    private int result;
    public int countSubstrings(String s) {
        this.result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            count(charArray, i, i);
            if (i != 0) {
                count(charArray, i - 1, i);
            }
        }
        return this.result;
    }

    private void count(char[] charArray, int left, int right) {
        if (left < 0 || right >= charArray.length || charArray[left] != charArray[right]) {
            return;
        }
        this.result++;
        count(charArray, left - 1, right + 1);
    }
}