// Last updated: 10/22/2025, 12:40:13 AM
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (charArray[i] != charArray[s.length() - 1 - i]) {
                char thisChar = charArray[i] < charArray[s.length() - 1 - i] ? charArray[i] : charArray[s.length() - 1 - i];
                charArray[i] = thisChar;
                charArray[s.length() - 1 - i] = thisChar;
            }
        }
        return String.valueOf(charArray);
    }
}