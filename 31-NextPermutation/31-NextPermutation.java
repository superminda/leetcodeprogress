// Last updated: 12/3/2025, 12:40:48 AM
1class Solution {
2
3    private static char DELIMILTER = ' ';
4    private static String MA = "ma";
5    private static String A = "a";
6    public String toGoatLatin(String sentence) {
7        String[] strs = sentence.split("\\s+");
8        StringBuilder sb = new StringBuilder();
9        for (int index = 0; index < strs.length; index++) {
10            char[] charArray = strs[index].toCharArray();
11            if (index != 0) {
12                sb.append(DELIMILTER);
13            }
14            if (isVowel(charArray[0])) {
15                sb.append(strs[index]);
16            } else {
17                for (int i = 1; i < charArray.length; i++) {
18                    sb.append(charArray[i]);
19                }
20                sb.append(charArray[0]);
21            }
22            sb.append(MA);
23            for (int i = 0; i <= index; i++) {
24                sb.append(A);
25            }
26        }
27        return sb.toString();
28    }
29
30    private boolean isVowel(char c) {
31        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
32    }
33}