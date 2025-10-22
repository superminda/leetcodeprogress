// Last updated: 10/22/2025, 12:39:25 AM
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int targetSize = set.size();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> currCount = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                currCount.add(nums[j]);
                if (currCount.size() == targetSize) {
                    result++;
                }
            }
        }
        return result;
    }
}