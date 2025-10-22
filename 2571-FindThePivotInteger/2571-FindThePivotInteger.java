// Last updated: 10/22/2025, 12:40:52 AM
class Solution {
    public int pivotInteger(int n) {
        int cal = n * n + n;
        if (cal % 2 != 0) {
            return -1;
        }
        cal /= 2;
        int result = (int)Math.sqrt((double)cal);
        if (result * result == cal) {
            return result;
        }
        return -1;
    }
}

// (1 + x) * x / 2 = (x + n) * (n - x + 1) / 2
// (1 + x) * x = (x + n) * (n - x + 1)
// 2 * x ^ 2 = n ^ 2 + n