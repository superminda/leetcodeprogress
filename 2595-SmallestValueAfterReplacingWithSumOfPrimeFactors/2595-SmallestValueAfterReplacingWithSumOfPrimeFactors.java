// Last updated: 10/22/2025, 12:40:48 AM
class Solution {
    private Map<Integer, List<Integer>> primeFactorMap;
    public int smallestValue(int n) {
        this.primeFactorMap = new HashMap<>();
        primeFactorMap.put(2, Arrays.asList(2));
        while (!primeFactorMap.containsKey(n) || primeFactorMap.get(n).size() > 1) {
            List<Integer> primeFactors = getPrimeFactors(n, primeFactorMap);
            int thisSum = 0;
            for (int primeFactor : primeFactors) {
                thisSum += primeFactor;
            }
            if (thisSum == n) {
                return n;
            }
            // System.out.println("replace with: " + thisSum);
            n = thisSum;
        }
        return n;
    }
    
    private List<Integer> getPrimeFactors(int num, Map<Integer, List<Integer>> primeFactorMap) {
        // System.out.println(num);
        if (primeFactorMap.containsKey(num)) {
            return primeFactorMap.get(num);
        }
        int initNum = num;
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if ((num % i) != 0) {
                continue;
            }
            List<Integer> subResult = getPrimeFactors(i, primeFactorMap);
            if (subResult.size() == 1) {
                result.add(i);
                num /= i;
                i--;
            }
        }
        if (num != 1) {
            result.add(num);
        }
        primeFactorMap.put(initNum, result);
        return result;
    }
}