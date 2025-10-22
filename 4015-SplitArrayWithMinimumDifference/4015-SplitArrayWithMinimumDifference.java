// Last updated: 10/22/2025, 12:39:06 AM
class Solution {
    public long splitArray(int[] nums) {
        List<Integer> maxIndexList = new ArrayList<>();
        int max = nums[0];
        maxIndexList.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndexList = new ArrayList<>();
                maxIndexList.add(i);
                max = nums[i];
            } else if (nums[i] == max) {
                maxIndexList.add(i);
            }
        }
        if (maxIndexList.size() > 1) {
            if (maxIndexList.size() == 2) {
                if (maxIndexList.get(1) - maxIndexList.get(0) != 1) {
                    return -1;
                }
            } else {
                return -1L;
            }
        }
        long[] preSum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum; 
        }
        if (maxIndexList.size() == 1) {
            for (int i = 1; i <= maxIndexList.get(0); i++) {
                if (nums[i] <= nums[i - 1]) {
                    return -1L;
                }
            }
            for (int i = maxIndexList.get(0); i < nums.length - 1; i++) {
                if (nums[i] <= nums[i + 1]) {
                    return -1L;
                }
            }
            int maxIndex = maxIndexList.get(0);
            if (maxIndex == 0) {
                return Math.abs((long)preSum[maxIndex] * 2 - sum);
            }
            if (maxIndex == nums.length - 1) {
                return Math.abs((long)preSum[maxIndex - 1] * 2 - sum);
            }
            return Math.min(Math.abs(preSum[maxIndex] * 2 - sum), Math.abs(preSum[maxIndex - 1] * 2 - sum));
        } else {
            for (int i = 1; i <= maxIndexList.get(0); i++) {
                if (nums[i] <= nums[i - 1]) {
                    return -1L;
                }
            }
            for (int i = maxIndexList.get(1); i < nums.length - 1; i++) {
                if (nums[i] <= nums[i + 1]) {
                    return -1L;
                }
            }
            return Math.abs(preSum[maxIndexList.get(0)] * 2 - sum);
        }
    }
}