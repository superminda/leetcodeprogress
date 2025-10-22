// Last updated: 10/22/2025, 12:39:32 AM
class Solution {
    public String smallestString(String s) {
        char[] charArray = s.toCharArray();
        boolean started = false;
        for (int i = 0; i < charArray.length; i++) {
            char thisChar = charArray[i];
            if (!started && thisChar > 'a') {
                started = true;
            }
            if (started) {
                if (thisChar > 'a') {
                    charArray[i] = (char)(thisChar - 1);
                } else {
                    break;
                }
            }
        }
        if (!started) {
            charArray[charArray.length - 1] = 'z';
        }
        return String.valueOf(charArray);
    }
}