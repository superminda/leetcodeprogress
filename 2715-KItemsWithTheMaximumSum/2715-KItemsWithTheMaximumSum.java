// Last updated: 10/22/2025, 12:40:29 AM
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        int sum = numOnes;
        k -= numOnes;
        if (numZeros >= k) {
            return sum;
        }
        k -= numZeros;
        return sum - k;
    }
}