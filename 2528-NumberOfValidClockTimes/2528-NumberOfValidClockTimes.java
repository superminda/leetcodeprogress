// Last updated: 10/22/2025, 12:40:59 AM
class Solution {
    public int countTime(String time) {
        char[] charArray = time.toCharArray();
        int pos1 = searchHour(charArray);
        int pos2 = searchMinute(charArray);
        return pos1 * pos2;
    }
    
    private int searchHour(char[] charArray) {
        if (charArray[0] == '?' && charArray[1] == '?') {
            return 24;
        } else if (charArray[0] == '?') {
            if (charArray[1] <= '3') {
                return 3;
            } else {
                return 2;
            }
        } else if (charArray[1] == '?') {
            if (charArray[0] <= '1') {
                return 10;
            } else {
                return 4;
            }
        } else {
            return 1;
        }
    }
    
    private int searchMinute(char[] charArray) {
        if (charArray[3] == '?' && charArray[4] == '?') {
            return 60;
        } else if (charArray[4] == '?') {
            return 10;
        } else if (charArray[3] == '?') {
            return 6;
        } else {
            return 1;
        }
    }
}