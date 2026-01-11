// Last updated: 1/10/2026, 10:57:36 PM
1class Solution {
2    public int residuePrefixes(String s) {
3        int result = 0;
4        Set<Character> set = new HashSet<>();
5        for (int i = 0; i < s.length(); i++) {
6            char c = s.charAt(i);
7            set.add(c);
8            if (set.size() == (i + 1) % 3) {
9                result++;
10            }
11        }
12        return result;
13    }
14}