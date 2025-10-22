// Last updated: 10/22/2025, 12:40:42 AM
class Solution {
    private Map<Integer, Set<Integer>> primeFactorsMap;
    public int findValidSplit(int[] nums) {
        this.primeFactorsMap = new HashMap<>();
        Map<Integer, Integer> maxIndexMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            Set<Integer> primeFactors = getPrimeDivisor(num);
            for (int primeFactor : primeFactors) {
                maxIndexMap.put(primeFactor, index);
            }
        }
        int maxIndex = 0;
        int index = 0;
        do {
            int num = nums[index];
            Set<Integer> primeFactors = getPrimeDivisor(num);
            for (int primeFactor : primeFactors) {
                maxIndex = Math.max(maxIndex, maxIndexMap.get(primeFactor));
            }
            index++;
        } while (index < maxIndex);
        if (maxIndex == nums.length - 1) {
            return -1;
        }
        return index;
    }
    
    private Set<Integer> getPrimeDivisor(int num) {
        int originalNum = num;
        if (this.primeFactorsMap.containsKey(num)) {
            return this.primeFactorsMap.get(num);
        }
        Set<Integer> result = new HashSet<>();
        if (num % 2 == 0) {
            result.add(2);
            while (num % 2 == 0) {
                num /= 2;
            }
        }
        for (int i = 3; i <= num / i; i+=2) {
            while (num % i == 0) {
                result.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            result.add(num);
        }
        this.primeFactorsMap.put(originalNum, result);
        return result;
    }
}