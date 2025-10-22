// Last updated: 10/22/2025, 12:41:10 AM
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];
            if (set.contains(num1)) {
                set.remove(num1);
            } else {
                set.add(num1);
            }
            if (set.contains(num2)) {
                set.remove(num2);
            } else {
                set.add(num2);
            }
            if (!map.containsKey(num1)) {
                map.put(num1, new ArrayList<Integer>());
            }
            map.get(num1).add(num2);
            if (!map.containsKey(num2)) {
                map.put(num2, new ArrayList<Integer>());
            }
            map.get(num2).add(num1);
        }
        Set<Integer> visitedSet = new HashSet<>();
        Iterator<Integer> it = set.iterator();
        int firstNum = it.next();
        int[] result = new int[n];
        result[0] = firstNum;
        visitedSet.add(firstNum);
        for (int i = 1; i < n; i++) {
            int lastNum = result[i - 1];
            List<Integer> neighbors = map.get(lastNum);
            int firstNeighbor = neighbors.get(0);
            if (visitedSet.contains(firstNeighbor)) {
                result[i] = neighbors.get(1);
            } else {
                result[i] = firstNeighbor;
            }
            visitedSet.add(result[i]);
        }
        return result;
    }
}