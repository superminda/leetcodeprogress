// Last updated: 10/22/2025, 12:40:43 AM
class Solution {
    public int passThePillow(int n, int time) {
        if (time == 1) {
            return 2;
        }
        time++;
        time %= (2 * n - 2);
        if (time == 0) {
            return 2;
        }
        int thisNum = 0;
        for (int i = 0; i < time; i++) {
            if (i < n) {
                thisNum++;
            } else {
                thisNum--;
            }
        }
        return thisNum;
    }
}