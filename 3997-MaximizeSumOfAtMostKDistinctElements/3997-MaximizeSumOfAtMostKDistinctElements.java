// Last updated: 10/22/2025, 12:39:09 AM
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < len; index++) {
            if (index > 0 && nums[len - index - 1] == nums[len - index - 1 + 1]) {
                continue;
            }
            list.add(nums[len - index - 1]);
            if (list.size() == k) {
                break;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}