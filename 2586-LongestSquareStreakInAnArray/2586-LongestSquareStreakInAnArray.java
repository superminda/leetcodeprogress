// Last updated: 10/22/2025, 12:40:50 AM
class Solution {
    public int longestSquareStreak(int[] nums) {
        int result = 1;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int squareRoot = getSquareRoot(nums[i]);
            int thisResult = map.getOrDefault(squareRoot, 0) + 1;
            map.put(nums[i], thisResult);
            result = Math.max(result, thisResult);
        }
        if (result == 1) {
            return -1;
        }
        return result;
    }
    
    private int getSquareRoot(int num) {
        int sqrt = (int)Math.sqrt((double)num);
        if (sqrt * sqrt == num) {
            return sqrt;
        }
        return -1;
    }
}