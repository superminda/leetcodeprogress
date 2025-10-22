// Last updated: 10/22/2025, 12:39:28 AM
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long result = 0L;
        Set<Integer> rowVisited = new HashSet<>();
        Set<Integer> columnVisited = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int value = queries[i][2];
            if (type == 0) {
                if (rowVisited.contains(index)) {
                    continue;
                }
                rowVisited.add(index);
                result += (long)value * (n - columnVisited.size());
            } else {
                if (columnVisited.contains(index)) {
                    continue;
                }
                columnVisited.add(index);
                result += (long)value * (n - rowVisited.size());
            }
        }
        return result;
    }
}