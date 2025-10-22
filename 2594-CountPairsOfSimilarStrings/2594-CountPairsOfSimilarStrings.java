// Last updated: 10/22/2025, 12:40:49 AM
class Solution {
    public int similarPairs(String[] words) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String mask = getMask(word);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        for (String word : map.keySet()) {
            int count = map.getOrDefault(word, 0);
            if (count == 0) {
                continue;
            }
            result += count * (count - 1) / 2;
        }
        return result;
    }
    
    public String getMask(String word) {
        char[] charArray = new char[26];
        for (int i = 0; i < word.length(); i++) {
            charArray[word.charAt(i) - 'a'] = word.charAt(i);
        }
        
        return String.valueOf(charArray);
    }
}