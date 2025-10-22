// Last updated: 10/22/2025, 12:39:27 AM
class Solution {
    public int findValueOfPartition(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if (set.size() != nums.length) {
            return 0;
        }
            
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            result = Math.min(result, nums[i] - nums[i - 1]);
        }
        return result;
    }
}