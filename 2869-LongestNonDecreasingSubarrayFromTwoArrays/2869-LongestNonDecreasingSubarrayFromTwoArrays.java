// Last updated: 10/22/2025, 12:39:22 AM
class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int result = 0;
        int n = nums1.length;
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int prevNum1 = (i == 0) ? -1 : nums1[i - 1];
            int prevNum2 = (i == 0) ? -1 : nums2[i - 1];
            arr1[i + 1] = 1;
            arr2[i + 1] = 1;
            if (nums1[i] >= prevNum1) {
                arr1[i + 1] = Math.max(arr1[i + 1], arr1[i] + 1);
            }
            if (nums1[i] >= prevNum2) {
                arr1[i + 1] = Math.max(arr1[i + 1], arr2[i] + 1);
            }
            if (nums2[i] >= prevNum1) {
                arr2[i + 1] = Math.max(arr2[i + 1], arr1[i] + 1);
            }
            if (nums2[i] >= prevNum2) {
                arr2[i + 1] = Math.max(arr2[i + 1], arr2[i] + 1);
            }
            result = Math.max(result, arr1[i + 1]);
            result = Math.max(result, arr2[i + 1]);
        }
        return result;
    }
}