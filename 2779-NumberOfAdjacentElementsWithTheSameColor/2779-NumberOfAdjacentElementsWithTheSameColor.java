// Last updated: 10/22/2025, 12:40:20 AM
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] array = new int[n];
        int[] result = new int[queries.length];
        int count = 0;
        for (int index = 0; index < queries.length; index++) {
            int coloredIndex = queries[index][0];
            int newColor = queries[index][1];
            int currColor = array[coloredIndex];
            if (currColor != newColor) {
                if (coloredIndex > 0) {
                    int prevColor = array[coloredIndex - 1];
                    if (prevColor != 0) {
                        if (prevColor == currColor) {
                            count--;
                        }
                        if (prevColor == newColor) {
                            count++;
                        }
                    }
                }
                if (coloredIndex < n - 1) {
                    int nextColor = array[coloredIndex + 1];
                    if (nextColor != 0) {
                        if (nextColor == currColor) {
                            count--;
                        }
                        if (nextColor == newColor) {
                            count++;
                        }
                    }
                }
            }
            array[coloredIndex] = newColor;
            result[index] = count;
        }
        return result;
    }
}