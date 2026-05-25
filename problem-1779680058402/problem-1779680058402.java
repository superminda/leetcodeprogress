// Last updated: 5/24/2026, 11:34:18 PM
1class Solution {
2    public int passwordStrength(String password) {
3        int result = 0;
4        Set<Character> set = new HashSet<>();
5        char[] charArray = password.toCharArray();
6        for (char c : charArray) {
7            set.add(c);
8        }
9        for (char c : set) {
10            if (c >= 'a' && c <= 'z') {
11                result += 1;
12            } else if (c >= 'A' && c <= 'Z') {
13                result += 2;
14            } else if (c >= '0' && c <= '9') {
15                result += 3;
16            } else {
17                result += 5;
18            }
19        }
20        return result;
21    }
22}