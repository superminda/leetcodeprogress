// Last updated: 10/22/2025, 12:39:15 AM
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int result = Integer.MAX_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int index = x; index < nums.size(); index++) {
            treeSet.add(nums.get(index - x));
            int thisNum = nums.get(index);
            if (treeSet.contains(thisNum)) {
                return 0;
            }
            Integer lowerNum = treeSet.lower(nums.get(index));
            if (lowerNum != null) {
                result = Math.min(result, thisNum - lowerNum);
            }
            Integer higherNum = treeSet.higher(nums.get(index));
            if (higherNum != null) {
                result = Math.min(result, higherNum - thisNum);
            }
        }
        return result;
    }
}