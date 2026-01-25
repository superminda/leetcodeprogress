// Last updated: 1/24/2026, 11:02:43 PM
1class Solution {
2    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
3        int result = 0;
4        int[] disX = new int[n];
5        int[] disY = new int[n];
6        int[] disZ = new int[n];
7        Map<Integer, Set<Integer>> neighborSet = new HashMap<>();
8        for (int[] edge : edges) {
9            int node1 = edge[0];
10            int node2 = edge[1];
11            if (!neighborSet.containsKey(node1)) {
12                neighborSet.put(node1, new HashSet<>());
13            }
14            neighborSet.get(node1).add(node2);
15            if (!neighborSet.containsKey(node2)) {
16                neighborSet.put(node2, new HashSet<>());
17            }
18            neighborSet.get(node2).add(node1);
19        }
20        bfs(x, disX, neighborSet);
21        bfs(y, disY, neighborSet);
22        bfs(z, disZ, neighborSet);
23        for (int i = 0; i < n; i++) {
24            int[] tri = new int[3];
25            tri[0] = disX[i];
26            tri[1] = disY[i];
27            tri[2] = disZ[i];
28            Arrays.sort(tri);
29            if ((long)tri[0] * tri[0] + (long)tri[1] * tri[1] == (long)tri[2] * tri[2]) {
30                result++;
31            }
32        }
33        return result++;
34    }
35
36    private void bfs(int startNode, int[] dis, Map<Integer, Set<Integer>> neighborSet) {
37        Set<Integer> visited = new HashSet<>();
38        visited.add(startNode);
39        Queue<Integer> queue = new LinkedList<>();
40        queue.offer(startNode);
41        visited.add(startNode);
42        int currDis = 0;
43        while (!queue.isEmpty()) {
44            int size = queue.size();
45            while (size > 0) {
46                size--;
47                int thisNode = queue.poll();
48                dis[thisNode] = currDis;
49                Set<Integer> neighbors = neighborSet.get(thisNode);
50                for (int neighbor : neighbors) {
51                    if (visited.contains(neighbor)) {
52                        continue;
53                    }
54                    queue.offer(neighbor);
55                    visited.add(neighbor);
56                }
57            }
58            currDis++;
59        }
60    }
61}