// Last updated: 10/22/2025, 12:41:04 AM
class Solution {
    public int commonFactors(int a, int b) {
        int result = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        List<Integer> factors = getFactor(min);
        if (min == max) {
            return factors.size();
        }
        for (int factor : factors) {
            if (max % factor == 0) {
                result++;
            }
        }
        return result;
    }
    
    private List<Integer> getFactor(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i != num) {
                    result.add(num / i);
                }
                result.add(i);
            }
        }
        return result;
    }
}