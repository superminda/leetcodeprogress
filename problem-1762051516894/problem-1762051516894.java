// Last updated: 11/1/2025, 10:45:16 PM
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            set.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        for (int num = min; num <= max; num++) {
            if (!set.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }
}