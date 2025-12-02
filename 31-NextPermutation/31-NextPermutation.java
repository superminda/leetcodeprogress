// Last updated: 12/2/2025, 1:33:24 AM
1class Solution {
2    private static int[] xMoves = {-1, 0, 1, 0};
3    private static int[] yMoves = {0, 1, 0, -1};
4    public int largestIsland(int[][] grid) {
5        int result = 0;
6        int n = grid.length;
7        int[][] groups = new int[n][n];
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < n; j++) {
10                if (grid[i][j] == 1) {
11                    groups[i][j] = i * n + j + 1;
12                }
13            }
14        }
15        for (int i = 0; i < n; i++) {
16            for (int j = 0; j < n; j++) {
17                if (grid[i][j] == 0) {
18                    continue;
19                }
20                for (int k = 0; k < xMoves.length; k++) {
21                    int newX = i + xMoves[k];
22                    int newY = j + yMoves[k];
23                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 0) {
24                        continue;
25                    }
26                    union(groups, i, j, newX, newY);
27                }
28            }
29        }
30        int[] count = new int[n * n + 1];
31        for (int i = 0; i < n; i++) {
32            for (int j = 0; j < n; j++) {
33                if (grid[i][j] == 0) {
34                    continue;
35                }
36                int thisGroup = findGroup(groups, i, j);
37                count[thisGroup]++;
38                result = Math.max(result, count[thisGroup]);
39            }
40        }
41        for (int i = 0; i < n; i++) {
42            for (int j = 0; j < n; j++) {
43                if (grid[i][j] == 1) {
44                    continue;
45                }
46                int thisCount = 1;
47                Set<Integer> groupSet = new HashSet<>();
48                for (int k = 0; k < xMoves.length; k++) {
49                    int newX = i + xMoves[k];
50                    int newY = j + yMoves[k];
51                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 0) {
52                        continue;
53                    }
54                    int thisGroup = findGroup(groups, newX, newY);
55                    if (groupSet.contains(thisGroup)) {
56                        continue;
57                    }
58                    groupSet.add(thisGroup);
59                    thisCount += count[thisGroup];
60                }
61                result = Math.max(result, thisCount);
62            }
63        }
64        return result;
65    }
66    
67    private void union(int[][] groups, int x1, int y1, int x2, int y2) {
68        int group1 = findGroup(groups, x1, y1);
69        int group2 = findGroup(groups, x2, y2);
70        int group1X = (group1 - 1) / groups.length;
71        int group1Y = (group1 - 1) % groups.length;
72        groups[group1X][group1Y] = group2;
73    }
74
75    private int findGroup(int[][] groups, int x, int y) {
76        if ((groups[x][y] - 1) / groups.length == x && y == (groups[x][y] - 1) % groups.length) {
77            return groups[x][y];
78        }
79        int fatherGroup = findGroup(groups, (groups[x][y] - 1) / groups.length, (groups[x][y] - 1) % groups.length);
80        groups[x][y] = fatherGroup;
81        return fatherGroup;
82    }
83}