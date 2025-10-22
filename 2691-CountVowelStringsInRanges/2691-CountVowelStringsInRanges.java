// Last updated: 10/22/2025, 12:40:36 AM
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counts = new int[words.length + 1];
        int thisCount = 0;
        for (int index = 0; index < words.length; index++) {
            if (isQualified(words[index])) {
                thisCount++;
            }
            counts[index + 1] = thisCount;
        }
        int[] result = new int[queries.length];
        for (int index = 0; index < queries.length; index++) {
            int[] query = queries[index];
            result[index] = counts[query[1] + 1] - counts[query[0]];
        }
        return result;
    }
    
    private boolean isQualified(String str) {
        char[] charArray = str.toCharArray();
        return isVowel(charArray[0]) && isVowel(charArray[charArray.length - 1]);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}