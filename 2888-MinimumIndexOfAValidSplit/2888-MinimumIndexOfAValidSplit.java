// Last updated: 10/22/2025, 12:39:19 AM
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int targetNum = nums.get(0);
        int targetCountMax = 1;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int currCount = countMap.getOrDefault(num, 0);
            currCount += 1;
            countMap.put(num, currCount);
            if (currCount > targetCountMax) {
                targetNum = num;
                targetCountMax = currCount;
            }
        }
        if (targetCountMax * 2 <= nums.size()) {
            return -1;
        }
        int currTargetCount = 0;
        int remainingTargetCount = targetCountMax;
        for (int index = 0; index < nums.size(); index++) {
            if (nums.get(index) == targetNum) {
                currTargetCount++;
                remainingTargetCount--;
            }
            if ((currTargetCount * 2 > index + 1) && (remainingTargetCount * 2 > (nums.size() - 1 - index))) {
                return index;
            }
        }
        return -1;
    }
}