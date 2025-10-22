// Last updated: 10/22/2025, 12:41:00 AM
class Solution {
    public int findMaxK(int[] nums) {
        int result = -1;
        Set<Integer> negativeSet = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                negativeSet.add(num);
            }
        }
        
        for (int num : nums) {
            if (num > 0 && negativeSet.contains(-num)) {
                result = Math.max(result, num);
            }
        }
        
        return result;
    }
}