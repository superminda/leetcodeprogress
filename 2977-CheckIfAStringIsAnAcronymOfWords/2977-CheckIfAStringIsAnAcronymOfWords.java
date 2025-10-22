// Last updated: 10/22/2025, 12:39:16 AM
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int index = 0; index < words.size(); index++) {
            if (words.get(index).charAt(0) != s.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}