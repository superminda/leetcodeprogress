// Last updated: 10/22/2025, 12:41:05 AM
class Solution {
    private int result;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.result = 0;
        int n = values.length;
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<String, Integer> edgeValueMap = new HashMap<>();
        for (int index = 0; index < edges.length; index++) {
            int[] edge = edges[index];
            int node1 = edge[0];
            int node2 = edge[1];
            if (!adjMap.containsKey(node1)) {
                adjMap.put(node1, new ArrayList<>());
            }
            adjMap.get(node1).add(node2);
            if (!adjMap.containsKey(node2)) {
                adjMap.put(node2, new ArrayList<>());
            }
            adjMap.get(node2).add(node1);
            edgeValueMap.put(Math.min(node1, node2) + "-" + Math.max(node1, node2), edge[2]);
        }
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int thisNode = queue.poll();
            if (!adjMap.containsKey(thisNode)) {
                continue;
            }
            List<Integer> neighbors = adjMap.get(thisNode);
            for (int neighbor : neighbors) {
                int costTime = edgeValueMap.get(Math.min(thisNode, neighbor) + "-" + Math.max(thisNode, neighbor));
                int reachNeighborTime = costTime + distances[thisNode];
                if (distances[neighbor] == -1 || distances[neighbor] > reachNeighborTime) {
                    distances[neighbor] = reachNeighborTime;
                    queue.offer(neighbor);
                }
            }
        }
        Set<String> visitedEdge = new HashSet<>();
        boolean[] visited = new boolean[n];
        // for (int i = 0; i < n; i++) {
        //     System.out.println("distance: " + distances[i]);
        // }
        dfs(0, maxTime, 0, 0, visitedEdge, adjMap, edgeValueMap, values, distances, visited);
        return this.result;
    }
    
    private void dfs(int node, int maxTime, int currentTime, int currentScore, Set<String> visitedEdge, Map<Integer, List<Integer>> adjMap, Map<String, Integer> edgeValueMap, int[] values, int[] distances, boolean[] visited) {
        if (currentTime + distances[node] > maxTime) {
            return;
        }
        boolean visitedStatus = visited[node];
        if (!visitedStatus) {
            currentScore += values[node];
        }
        this.result = Math.max(this.result, currentScore);
        if (!adjMap.containsKey(node)) {
            return;
        }
        visited[node] = true;
        List<Integer> neighbors = adjMap.get(node);
        for (int neighbor : neighbors) {
            String edgeToBeVisited = node + "-" + neighbor;
            if (visitedEdge.contains(edgeToBeVisited)) {
                continue;
            }
            visitedEdge.add(edgeToBeVisited);
            int costTime = edgeValueMap.get(Math.min(node, neighbor) + "-" + Math.max(node, neighbor));
            dfs(neighbor, maxTime, currentTime + costTime, currentScore, visitedEdge, adjMap, edgeValueMap, values, distances, visited);
            visitedEdge.remove(edgeToBeVisited);
        }
        visited[node] = visitedStatus;
        if (!visitedStatus) {
            currentScore -= values[node];
        }
    }
}