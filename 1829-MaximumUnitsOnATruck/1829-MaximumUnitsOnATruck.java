// Last updated: 10/22/2025, 12:41:12 AM
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int[] boxType : boxTypes) {
            heap.offer(boxType);
        }
        while (!heap.isEmpty() && truckSize > 0) {
            int[] thisBoxType = heap.poll();
            int numberOfBoxes = thisBoxType[0];
            int numberOfUnitsPerBox = thisBoxType[1];
            if (numberOfBoxes >= truckSize) {
                result += truckSize * numberOfUnitsPerBox;
                break;
            } else {
                result += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            }
        }
        return result;
    }
}