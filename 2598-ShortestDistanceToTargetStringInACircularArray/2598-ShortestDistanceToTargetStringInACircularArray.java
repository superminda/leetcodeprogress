// Last updated: 10/22/2025, 12:40:47 AM
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int result = 0;
        int n = words.length;
        int headIndex = startIndex;
        int tailIndex = startIndex;
        while (result <= n / 2) {
            if (words[headIndex].equals(target)) {
                return result;
            }
            if (words[tailIndex].equals(target)) {
                return result;
            }
            result++;
            headIndex = (headIndex + n - 1) % n;
            tailIndex = (tailIndex + 1) % n;
        }
        return -1;
    }
}