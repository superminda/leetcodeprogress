// Last updated: 10/22/2025, 12:39:13 AM
class Solution {
    public char kthCharacter(int k) {
        char[] charArray = new char[k];
        charArray[0] = 'a';
        
        int index = 1;
        for (int len = 1; len < k; len *= 2) {
            for (int lenIndex = 0; lenIndex < len; lenIndex++) {
                charArray[index] = (char)(charArray[index - len] + 1);
                index++;
                if (index == k) {
                    return charArray[k - 1];
                }
            }
        }
        return 'a';
    }
}