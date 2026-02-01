// Last updated: 1/31/2026, 11:05:35 PM
1class Solution {
2    public int countMonobit(int n) {
3        if (n == 0) {
4            return 1;
5        }
6        if (n == 1) {
7            return 2;
8        }
9        Double result = (Math.log(n + 1) / Math.log(2));
10        return result.intValue() + 1;
11    }
12}