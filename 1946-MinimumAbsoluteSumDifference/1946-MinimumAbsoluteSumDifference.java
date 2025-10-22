// Last updated: 10/22/2025, 12:41:07 AM
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int index = 0;
        int maxDiff = 0;
        int sumDiff = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            int currentDiff = Math.abs(nums1[i] - nums2[i]);
            if (currentDiff > maxDiff) {
                index = i;
                maxDiff = currentDiff;
            }
            sumDiff += currentDiff;
            sumDiff = sumDiff % (1000000000 + 7);
        }
        
        
        int minDiff = maxDiff;
        for (int i = 0; i < nums1.length; i++) {
            if (i == index) {
                continue;
            }
            int currentDiff = Math.abs(nums2[index] - nums1[i]);
            minDiff = Math.min(minDiff, currentDiff);
        }
        
        return (sumDiff - maxDiff + minDiff) % (1000000000 + 7);
    }
}