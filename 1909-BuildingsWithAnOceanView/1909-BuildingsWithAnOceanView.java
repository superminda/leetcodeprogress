// Last updated: 10/22/2025, 12:41:08 AM
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int currentMax = 0;
        for (int index = heights.length - 1; index >= 0; index--) {
            if (heights[index] > currentMax) {
                list.add(index);
            }
            currentMax = Math.max(currentMax, heights[index]);
        }
        int size = list.size();
        int[] result = new int[size];
        for (int index = 0; index < size; index++) {
            result[index] = list.get(size - 1 - index);
        }
        return result;
    }
}