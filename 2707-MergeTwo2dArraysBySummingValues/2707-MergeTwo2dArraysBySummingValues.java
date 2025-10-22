// Last updated: 10/22/2025, 12:40:33 AM
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> tempResult = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1][0] < nums2[index2][0]) {
                tempResult.add(nums1[index1++]);
            } else if (nums1[index1][0] > nums2[index2][0]) {
                tempResult.add(nums2[index2++]);
            } else {
                tempResult.add(new int[]{nums1[index1][0], nums1[index1][1] + nums2[index2][1]});
                index1++;
                index2++;
            }
        }
        while (index1 < nums1.length) {
            tempResult.add(nums1[index1++]);
        }
        while (index2 < nums2.length) {
            tempResult.add(nums2[index2++]);
        }
        int[][] result = new int[tempResult.size()][2];
        for (int index = 0; index < tempResult.size(); index++) {
            result[index] = tempResult.get(index);
        }
        return result;
    }
}