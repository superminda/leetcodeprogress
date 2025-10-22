// Last updated: 10/22/2025, 12:38:59 AM
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num = k; num <= 100 + k; num += k) {
            if (!set.contains(num)) {
                return num;
            }
        }
        return 0;
    }
}