// Last updated: 12/5/2025, 12:00:08 AM
1class Solution {
2    public int maximumSwap(int num) {
3        char[] charArray = String.valueOf(num).toCharArray();
4        for (int i = 0; i < charArray.length; i++) {
5            char maxBiggerChar = (char)(charArray[i] + 1);
6            int maxCharIndex = -1;
7            for (int j = i + 1; j < charArray.length; j++) {
8                char thisChar = charArray[j];
9                if (thisChar >= maxBiggerChar) {
10                    maxCharIndex = j;
11                    maxBiggerChar = thisChar;
12                }
13            }
14            if (maxCharIndex == -1) {
15                continue;
16            }
17
18            char temp = charArray[i];
19            charArray[i] = charArray[maxCharIndex];
20            charArray[maxCharIndex] = temp;
21
22            int result = 0;
23            for (int idx = 0; idx < charArray.length; idx++) {
24                result = 10 * result + (charArray[idx] - '0');
25            }
26            return result;
27        }
28        return num;
29    }
30}