// Last updated: 12/13/2025, 11:59:15 PM
1class Solution {
2    public long minMoves(int[] balance) {
3        long result = 0l;
4        int n = balance.length;
5        long sum = 0l;
6        int negativeIndex = -1;
7        for (int index = 0; index < balance.length; index++) {
8            int v = balance[index];
9            sum += v;
10            if (v < 0) {
11                negativeIndex = index;
12            }
13        }
14        if (negativeIndex == -1) {
15            return 0l;
16        }
17        if (sum < 0l) {
18            return -1l;
19        }
20        int start = (negativeIndex + n - 1) % n;
21        int end = (negativeIndex + 1) % n;
22        boolean hasStartEndMet = false;
23        while (!hasStartEndMet && balance[negativeIndex] < 0) {
24            if (start == end) {
25                hasStartEndMet = true;
26            }
27            int disStart = start > negativeIndex ? (negativeIndex + 1 + n - 1 - start) : (negativeIndex - start);
28            int disEnd = end > negativeIndex ? (end - negativeIndex) : (n - 1 - negativeIndex + 1 + end);
29            int targetIndex = disStart <= disEnd ? start : end;
30            if (balance[targetIndex] >= Math.abs(balance[negativeIndex])) {
31                result += Math.abs(balance[negativeIndex]) * (long)Math.min(disStart, disEnd);
32                return result;
33            } else {
34                result += balance[targetIndex] * (long)Math.min(disStart, disEnd);
35                balance[negativeIndex] += balance[targetIndex];
36                balance[targetIndex] = 0;
37            }
38            if (targetIndex == start) {
39                start = (start + n - 1) % n;
40            } else {
41                end = (end + 1) % n;
42            }
43        }
44        return -1l;
45    }
46}