// Last updated: 10/22/2025, 12:40:17 AM
class Solution {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int curr = 0;
        int count = 0;
        while (!set.contains(curr)) {
            set.add(curr);
            curr += (++count * k);
            curr %= n;
        }
        List<Integer> tempResult = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i - 1)) {
                tempResult.add(i);
            }
        }
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        return result;
    }
}