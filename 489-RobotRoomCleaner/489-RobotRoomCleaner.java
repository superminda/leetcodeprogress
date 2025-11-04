// Last updated: 11/3/2025, 11:26:38 PM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int prevIndex = map.getOrDefault(nums[index], -1);
            if (prevIndex != -1 && index - prevIndex <= k) {
                return true;
            }
            map.put(nums[index], index);
        }
        return false;
    }
}