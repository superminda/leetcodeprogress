// Last updated: 1/17/2026, 10:51:36 PM
1class Solution {
2    public int vowelConsonantScore(String s) {
3        char[] charArray = s.toCharArray();
4        int vowelCount = 0;
5        int consonantCount = 0;
6        for (char c : charArray) {
7            if (c == ' ' || isNumber(c)) {
8                continue;
9            } else if (isVowel(c)) {
10                vowelCount++;
11            } else {
12                consonantCount++;
13            }
14        }
15        if (consonantCount == 0) {
16            return 0;
17        } else {
18            return vowelCount / consonantCount;
19        }
20    }
21
22    private boolean isVowel(char c) {
23        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
24    }
25
26    private boolean isNumber(char c) {
27        return c >= '0' && c <= '9';
28    }
29}