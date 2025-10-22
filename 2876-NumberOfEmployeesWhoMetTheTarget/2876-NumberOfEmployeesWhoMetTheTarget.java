// Last updated: 10/22/2025, 12:39:21 AM
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;
        for (int hour : hours) {
            if (target <= hour) {
                result++;
            }
        }
        return result;
    }
}