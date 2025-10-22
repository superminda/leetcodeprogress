// Last updated: 10/22/2025, 12:40:22 AM
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int count = 0;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int numA = A[i];
            int numB = B[i];
            if (!setA.contains(numA) && setB.contains(numA)) {
                count++;
            }
            setA.add(numA);
            if (!setB.contains(numB) && setA.contains(numB)) {
                count++;
            }
            setB.add(numB);
            result[i] = count;
        }
        return result;
    }
}