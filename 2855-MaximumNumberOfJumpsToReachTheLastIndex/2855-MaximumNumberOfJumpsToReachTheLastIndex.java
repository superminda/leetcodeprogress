// Last updated: 10/22/2025, 12:39:26 AM
class Solution {
    public int maximumJumps(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int thisResult = -1;
            for (int prevNum : map.keySet()) {
                if (Math.abs(nums[i] - prevNum) <= target && map.getOrDefault(prevNum, -1) >= 0) {
                    thisResult = Math.max(thisResult, map.get(prevNum) + 1);
                }
            }
            map.put(nums[i], thisResult);
        }
        return map.getOrDefault(nums[nums.length - 1], -1);
    }
}