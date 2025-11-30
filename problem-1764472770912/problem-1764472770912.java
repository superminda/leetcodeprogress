// Last updated: 11/29/2025, 10:19:30 PM
1class Solution {
2    public int maxDistinct(String s) {
3        Set<Character> set = new HashSet<>();
4        char[] charArray = s.toCharArray();
5        for (char c : charArray) {
6            set.add(c);
7        }
8        return set.size();
9    }
10}