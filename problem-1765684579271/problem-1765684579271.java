// Last updated: 12/13/2025, 10:56:19 PM
1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.split("\\s+");
4        int targetVowelCount = getVowelCount(words[0]);
5        StringBuilder sb = new StringBuilder();
6        sb.append(words[0]);
7        for (int i = 1; i < words.length; i++) {
8            sb.append(' ');
9            int thisVowelCount = getVowelCount(words[i]);
10            if (targetVowelCount == thisVowelCount) {
11                String reversedString = reverseString(words[i]);
12                sb.append(reversedString);
13            } else {
14                sb.append(words[i]);
15            }
16        }
17        return sb.toString();
18    }
19
20    private String reverseString(String str) {
21        char[] charArray = str.toCharArray();
22        int start = 0;
23        int end = charArray.length - 1;
24        while (start < end) {
25            char temp = charArray[start];
26            charArray[start] = charArray[end];
27            charArray[end] = temp;
28            start++;
29            end--;
30        }
31        return String.valueOf(charArray);
32    }
33
34    private int getVowelCount(String str) {
35        int count = 0;
36        char[] charArray = str.toCharArray();
37        for (char c : charArray) {
38            if (isVowel(c)) {
39                count++;
40            }
41        }
42        return count;
43    }
44    
45    private boolean isVowel(char c) {
46        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
47    }
48}