// Last updated: 10/22/2025, 12:40:28 AM
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Long> indexSumMap = new HashMap<>();
        for (int index = 0; index < n; index++) {
            int thisNum = nums[index];
            int thisCount = countMap.getOrDefault(thisNum, 0);
            long thisIndexSum = indexSumMap.getOrDefault(thisNum, 0L);
            long subResult = 0L;
            if (thisCount != 0) {
                result[index] += ((long)thisCount * index - thisIndexSum);
            }
            countMap.put(thisNum, thisCount + 1);
            indexSumMap.put(thisNum, thisIndexSum + (long)index);
        }
        
        countMap = new HashMap<>();
        indexSumMap = new HashMap<>();
        for (int index = n - 1; index >= 0; index--) {
            int thisNum = nums[index];
            int thisCount = countMap.getOrDefault(thisNum, 0);
            long thisIndexSum = indexSumMap.getOrDefault(thisNum, 0L);
            long subResult = 0L;
            if (thisCount != 0) {
                result[index] += (thisIndexSum - (long)thisCount * index);
            }
            countMap.put(thisNum, thisCount + 1);
            indexSumMap.put(thisNum, thisIndexSum + (long)index);
        }
        return result;
    }
}