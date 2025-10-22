// Last updated: 10/22/2025, 12:40:12 AM
class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            set.add(c);
        }
        return set.size();
    }
}