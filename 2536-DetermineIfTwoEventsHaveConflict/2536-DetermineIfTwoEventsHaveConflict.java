// Last updated: 10/22/2025, 12:40:58 AM
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int event1Start = getMinutes(event1[0]);
        int event1End = getMinutes(event1[1]);
        int event2Start = getMinutes(event2[0]);
        int event2End = getMinutes(event2[1]);
        if (event1Start < event2Start) {
            return event1End >= event2Start;
        } else if (event1Start > event2Start) {
            return event2End >= event1Start;
        }
        return false;
    }
    
    private int getMinutes(String time) {
        String[] times = time.split(":");
        int hour = Integer.valueOf(times[0]);
        int minute = Integer.valueOf(times[1]);
        return hour * 60 + minute;
    }
}