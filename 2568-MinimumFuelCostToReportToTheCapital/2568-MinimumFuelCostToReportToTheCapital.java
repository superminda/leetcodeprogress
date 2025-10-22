// Last updated: 10/22/2025, 12:40:53 AM
class Solution {
    private long result;
    public long minimumFuelCost(int[][] roads, int seats) {
        // System.out.println("hhihihihihihihihihihihihihihihihihihii");
        this.result = 0l;
        if (roads.length == 0) {
            return result;
        }
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            adjMap.get(from).add(to);
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(to).add(from);
        }
        boolean[] visited = new boolean[roads.length + 1];
        visited[0] = true;
        getCount(0, visited, adjMap, seats);
        // Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // queue.offer(new Pair<Integer, Integer>(0, 0));
        // visited[0] = true;
        // while (!queue.isEmpty()) {
        //     Pair<Integer, Integer> thisPair = queue.poll();
        //     int thisCity = thisPair.getKey();
        //     int nodeCount = thisPair.getValue();
        //     boolean foundNotVisitedNeighbor = false;
        //     for (int neighbor : adjMap.get(thisCity)) {
        //         if (visited[neighbor]) {
        //             continue;
        //         }
        //         visited[neighbor] = true;
        //         foundNotVisitedNeighbor = true;
        //         queue.offer(new Pair<Integer, Integer>(neighbor, nodeCount + 1));
        //     }
        //     if (!foundNotVisitedNeighbor) {
        //         result += getCountCost(nodeCount, seats);
        //     }
        // }
        return this.result;
    }
    
    private int getCount(int city, boolean[] visited, Map<Integer, List<Integer>> adjMap, int seats) {
        // System.out.println("THIS CITY " + city);
        int totalCity = 1;
        for (int neighbor : adjMap.get(city)) {
            if (visited[neighbor]) {
                continue;
            }
            visited[neighbor] = true;
            totalCity += getCount(neighbor, visited, adjMap, seats);
        }
        if (city != 0) {
            int thisResult = ((totalCity / seats) + (((totalCity % seats) != 0) ? 1 : 0));
            // System.out.println("thisResult: " + thisResult + " for " + city);
            // System.out.println("totalCity: " + totalCity);
            this.result += thisResult;
        }
        return totalCity;
    }
}