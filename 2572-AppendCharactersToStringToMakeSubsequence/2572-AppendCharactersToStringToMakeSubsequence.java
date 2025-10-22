// Last updated: 10/22/2025, 12:40:52 AM
class Solution {
    public int appendCharacters(String s, String t) {
        int count = 0;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length() && indexS < s.length()) {
            if (sCharArray[indexS] == tCharArray[indexT]) {
                count++;
                indexS++;
                indexT++;
            } else {
                indexS++;
            }
        }
        return t.length() - count;
    }
}