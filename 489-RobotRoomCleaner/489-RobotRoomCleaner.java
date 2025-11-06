// Last updated: 11/6/2025, 1:01:52 AM
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        char[] charArray = num.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start <= end) {
            if (map.getOrDefault(charArray[start] - '0', -1) != (charArray[end] - '0')) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}