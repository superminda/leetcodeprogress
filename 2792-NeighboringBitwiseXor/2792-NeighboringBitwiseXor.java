// Last updated: 10/22/2025, 12:40:17 AM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] origin1 = new int[n];
        origin1[0] = 1;
        for (int i = 1; i < n; i++) {
            origin1[i] = origin1[i - 1] ^ derived[i];
        }
        if ((origin1[n - 1] ^ origin1[0]) == derived[0]) {
            return true;
        }
        int[] origin2 = new int[n];
        origin2[0] = 0;
        for (int i = 1; i < n; i++) {
            origin2[i] = origin2[i - 1] ^ derived[i];
        }
        if ((origin2[n - 1] ^ origin2[0]) == derived[0]) {
            return true;
        }
        return false;
    }
}