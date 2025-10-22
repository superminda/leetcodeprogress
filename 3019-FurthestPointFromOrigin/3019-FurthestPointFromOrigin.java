// Last updated: 10/22/2025, 12:39:14 AM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        char[] charArray = moves.toCharArray();
        int count = 0;
        int underscoreCount = 0;
        for (char c : charArray) {
            if (c == 'L') {
                count++;
            } else if (c == 'R') {
                count--;
            } else {
                underscoreCount++;
            }
        }
        return Math.abs(count) + underscoreCount;
    }
}