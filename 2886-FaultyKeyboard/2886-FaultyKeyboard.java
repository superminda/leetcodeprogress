// Last updated: 10/22/2025, 12:39:19 AM
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == 'i') {
                sb = sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}