// Last updated: 10/22/2025, 12:40:58 AM
class Solution {
    public boolean equalFrequency(String word) {
        int[] counts = new int[26];
        int distinctCharCount = 0;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            if (counts[c - 'a'] == 0) {
                distinctCharCount++;
            }
            counts[c - 'a']++;
        }
        
        if (distinctCharCount == 1) {
            return true;
        }
        Map<Integer, Integer> distinctCountMap = new HashMap<>();
        for (int index = 0; index < 26; index++) {
            if (counts[index] != 0) {
                distinctCountMap.put(counts[index], distinctCountMap.getOrDefault(counts[index], 0) + 1);
            }
        }
        List<Integer> distinctCountList = new ArrayList<>();
        List<Integer> distinctCountFreqList = new ArrayList<>();
        
        for (int key : distinctCountMap.keySet()) {
            distinctCountList.add(key);
            distinctCountFreqList.add(distinctCountMap.get(key));
        }
        if (distinctCountList.size() > 2) {
            return false;
        }
        if (distinctCountList.size() == 1) {
            return distinctCountList.get(0) == 1;
        } else {
            if (Math.abs(distinctCountList.get(0) - distinctCountList.get(1)) != 1) {
                return false;
            }
            return distinctCountFreqList.get(0) == 1 || distinctCountFreqList.get(1) == 1;
        }
    }
}