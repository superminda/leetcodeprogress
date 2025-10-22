// Last updated: 10/22/2025, 12:40:40 AM
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        for (int index = left; index <= right; index++) {
            String word = words[index];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}