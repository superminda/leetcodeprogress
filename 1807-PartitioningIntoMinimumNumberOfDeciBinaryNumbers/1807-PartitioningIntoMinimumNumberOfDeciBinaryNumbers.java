// Last updated: 10/22/2025, 12:41:13 AM
class Solution {
    public int minPartitions(String n) {
        int result = 0;
        char[] charArray = n.toCharArray();
        for (char c : charArray) {
            int offset = c - '0';
            result = Math.max(result, offset);
            if (result == 9) {
                return result;
            }
        }
        return result;
    }
}