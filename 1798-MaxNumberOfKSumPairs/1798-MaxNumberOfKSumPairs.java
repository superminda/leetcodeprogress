// Last updated: 10/22/2025, 12:41:15 AM
class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : map.keySet()) {
            int target = k - num;
            if (map.containsKey(target)) {
                result += Math.min(map.get(num), map.get(target));
            }
        }
        return result / 2;
    }
}