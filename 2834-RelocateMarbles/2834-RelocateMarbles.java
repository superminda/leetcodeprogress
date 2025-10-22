// Last updated: 10/22/2025, 12:39:30 AM
class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int index = 0; index < moveFrom.length; index++) {
            int from = moveFrom[index];
            int to = moveTo[index];
            set.remove(from);
            set.add(to);
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}