// Last updated: 10/22/2025, 12:39:34 AM
class Solution {
    public int minimumSum(int n, int k) {
        int result = 0;
        Set<Integer> avoidNums = new HashSet<>();
        int count = 0;
        int thisNum = 1;
        while (count < n) {
            if (thisNum >= k) {
                result += (thisNum + thisNum + (n - count) - 1) * (n - count) / 2;
                return result;
            }
            if (avoidNums.contains(thisNum)) {
                thisNum++;
                continue;
            }
            result += thisNum;
            count++;
            if (k - thisNum > 0) {
                avoidNums.add(k - thisNum);
            }
            thisNum++;
        }
        return result;
    }
}