// Last updated: 10/22/2025, 12:41:13 AM
class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int numOfFullWeeks = n / 7;
        int lastWeekDaysCount = n % 7;
        int firstWeekCount = 28;
        int lastWeekMondayCount = 1 + numOfFullWeeks;
        if (numOfFullWeeks > 0) {
            result += (firstWeekCount + firstWeekCount + (numOfFullWeeks - 1) * 7) * numOfFullWeeks / 2;
        }
        result += (lastWeekMondayCount + lastWeekMondayCount + (lastWeekDaysCount - 1)) * lastWeekDaysCount / 2 ;
        return result;
    }
}