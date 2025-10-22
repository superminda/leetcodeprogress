// Last updated: 10/22/2025, 12:40:21 AM
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] distinctFromStart = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {
            set.add(nums[index]);
            distinctFromStart[index] = set.size();
        }
        set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            result[i] = distinctFromStart[i] - set.size();
            set.add(nums[i]);
        }
        return result;
    }
}