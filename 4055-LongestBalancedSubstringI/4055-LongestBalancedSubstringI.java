// Last updated: 10/22/2025, 12:39:03 AM
class Solution {
    public int longestBalanced(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int[][] count = new int[charArray.length + 1][26];
        for (int index = 0; index < charArray.length; index++) {
            char thisChar = charArray[index];
            for (int charIndex = 0; charIndex < 26; charIndex++) {                
                count[index + 1][charIndex] = count[index][charIndex];
            }
            count[index + 1][thisChar - 'a']++;
        }
        for (int start = 0; start < charArray.length; start++) {
            for (int end = start + 1; end <= charArray.length; end++) {
                int freq = -1;
                boolean hasSameFreq = true;
                for (int charIndex = 0; charIndex < 26; charIndex++) {
                    int thisFreq = count[end][charIndex] - count[start][charIndex];
                    if (thisFreq == 0) {
                        continue;
                    } 
                    if (freq == -1) {
                        freq = thisFreq;
                    } else {
                        if (freq != thisFreq) {
                            hasSameFreq = false;
                            break;
                        }
                    }
                }
                if (hasSameFreq) {
                    result = Math.max(result, end - start);
                }
            }
        }
        return result;
    }
}