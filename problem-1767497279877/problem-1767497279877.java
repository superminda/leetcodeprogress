// Last updated: 1/3/2026, 10:27:59 PM
1class Solution {
2    public String largestEven(String s) {
3        if (s.charAt(s.length() - 1) == '2') {
4            return s;
5        } else {
6            char[] charArray = s.toCharArray();
7            int index = charArray.length - 1;
8            while (index >= 0) {
9                if (charArray[index] == '1') {
10                    index--;
11                } else {
12                    break;
13                }
14            }
15            return s.substring(0, index + 1);
16        }
17    }
18}