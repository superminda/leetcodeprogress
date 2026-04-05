// Last updated: 4/4/2026, 10:57:58 PM
1class Solution {
2    public int mirrorFrequency(String s) {
3        int result = 0;
4        int[] lettersCount = new int[26];
5        int[] digitsCounts = new int[10];
6        char[] charArray = s.toCharArray();
7        for (char c : charArray) {
8            if (c >= 'a' && c <= 'z') {
9                lettersCount[c - 'a']++;
10            } else {
11                digitsCounts[c - '0']++;
12            }
13        }
14        for (int i = 0; i < 13; i++) {
15            result += Math.abs(lettersCount[i] - lettersCount[25 - i]);
16        }
17        for (int i = 0; i < 5; i++) {
18            result += Math.abs(digitsCounts[i] - digitsCounts[9 - i]);
19        }
20        return result;
21    }
22}