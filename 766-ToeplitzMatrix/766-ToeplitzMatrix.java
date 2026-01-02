// Last updated: 1/1/2026, 11:30:17 PM
1class Solution {
2    public boolean isToeplitzMatrix(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        for (int delta = 0; delta < n; delta++) {
6            int target = matrix[0][delta];
7            for (int i = 1; i < m; i++) {
8                int j = i + delta;
9                if (j >= n) {
10                    break;
11                }
12                if (matrix[i][j] != target) {
13                    return false;
14                }
15            }
16        }
17        for (int delta = 1; delta < m; delta++) {
18            int target = matrix[delta][0];
19            for (int j = 1; j < n; j++) {
20                int i = j + delta;
21                if (i >= m) {
22                    break;
23                }
24                if (matrix[i][j] != target) {
25                    return false;
26                }
27            }
28        }
29        return true;
30    }
31}