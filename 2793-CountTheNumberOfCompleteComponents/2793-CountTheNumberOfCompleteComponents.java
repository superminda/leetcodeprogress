// Last updated: 10/22/2025, 12:40:16 AM
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int result = 0;
        int[] father = new int[n + 1];
        Map<Integer, Integer> edgeCount = new HashMap<>();
        Map<Integer, Integer> nodeCount = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            int from = edge[0] + 1;
            int to = edge[1] + 1;
            connect(father, from, to);
        }
        for (int i = 1; i <= n; i++) {
            getFather(father, i);
        }
        for (int i = 1; i <= n; i++) {
            int thisFather = getFather(father, i);
            nodeCount.put(thisFather, nodeCount.getOrDefault(thisFather, 0) + 1);
        }
        
        for (int[] edge : edges) {
            int from = edge[0] + 1;
            int to = edge[1] + 1;
            int min = Math.min(from, to);
            int thisFather = getFather(father, min);
            edgeCount.put(thisFather, edgeCount.getOrDefault(thisFather, 0) + 1);
        }
        for (int thisFather : nodeCount.keySet()) {
            // System.out.println("thisFatherL: " + thisFather);
            // System.out.println("edgeCount: " + edgeCount.getOrDefault(thisFather, 0));
            // System.out.println("nodeCount: " + nodeCount.get(thisFather));
            if (edgeCount.getOrDefault(thisFather, 0) == nodeCount.get(thisFather) * (nodeCount.get(thisFather) - 1) / 2) {
                result++;
            }
        }
        // System.out.println(" ");
        return result;
    }
    
    private void connect(int[] father, int from, int to) {
        int fatherFrom = getFather(father, from);
        int fatherTo = getFather(father, to);
        father[Math.min(fatherFrom, fatherTo)] = Math.max(fatherFrom, fatherTo);
    }
    
    private int getFather(int[] father, int num) {
        if (father[num] == num) {
            return num;
        }
        father[num] = getFather(father, father[num]);
        return father[num];
    }
}