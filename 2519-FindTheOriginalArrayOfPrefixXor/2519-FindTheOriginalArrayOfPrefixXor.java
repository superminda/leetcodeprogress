// Last updated: 10/22/2025, 12:41:01 AM
class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        for (int i = n - 1; i >= 1; i--) {
            arr[i] = pref[i] ^ pref[i - 1];
        }
        arr[0] = pref[0];
        return arr;
    }
}